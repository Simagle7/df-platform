/*
{*****************************************************************************
{  疾病预测 v1.0													
{  版权信息 (c) 2005-2017 Katybaby. 保留所有权利.
{  创建人：  Katybaby
{  审查人：
{  模块：权限操作表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2017-02-21  Katybaby        新建	
{ 	                                                                     
{*****************************************************************************
*/

package cn.df.service.auth;

import cn.df.common.domain.BizData4Page;
import cn.df.common.dto.user.AccountDto;
import cn.df.common.exception.BizException;
import cn.df.common.utils.base.DataStatusEnum;
import cn.df.common.utils.base.ERRORCODE;
import cn.df.common.utils.base.RETURNCODE;
import cn.df.common.utils.sys.CommonUtils;
import cn.df.common.utils.sys.PageUtils;
import cn.df.dao.IDFBaseDAO;
import cn.df.dao.auth.IAuthModuleDAO;
import cn.df.dao.auth.IAuthOperationDAO;
import cn.df.domain.auth.AuthModule;
import cn.df.domain.auth.AuthOperation;
import cn.df.domain.auth.AuthOperationEx;
import cn.df.param.auth.AuthModuleParam;
import cn.df.param.auth.AuthOperationParam;
import cn.df.service.AbstractDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 《权限操作》 业务逻辑服务类
 *
 * @author Katybaby
 */
@Service("AuthOperationServiceImpl")
public class AuthOperationServiceImpl extends AbstractDFService<IDFBaseDAO<AuthOperation>, AuthOperation> implements IAuthOperationService<IDFBaseDAO<AuthOperation>, AuthOperation> {
    @Autowired
    private IAuthOperationDAO authOperationDAO;
    @Autowired
    private IAuthModuleDAO authModuleDAO;
    @Autowired
    private IAuthRoleService authRoleService;

    @Override
    public IDFBaseDAO<AuthOperation> getDao() {
        return authOperationDAO;
    }

    @Override
    public BizData4Page queryPage(AuthOperationParam param, int pageNo, int pageSize) {
        //查询操作集合
        List<AuthOperationEx> data = authOperationDAO.queryPageEx(param.toMap(), (pageNo - 1) * pageSize, pageSize);
        //查询操作总数
        int records = authOperationDAO.countEx(param.toMap());
        //返回，结果集封装
        return PageUtils.toBizData4Page(data, pageNo, pageSize, records);
    }

    @Override
    public String add(AuthOperationParam param, AccountDto currentUser) {
        // 查询是否存在操作名，操作名要求唯一
        if (isExists(AuthOperationParam.F_Name, param.getName())) {
            throw new BizException(ERRORCODE.OPERATION_EXIST.getCode(), ERRORCODE.OPERATION_EXIST.getMessage());
        }
        //查询是否存在权限代码，权限代码要求唯一
        if (isExists(AuthOperationParam.F_AuthCode, param.getAuthCode())) {
            throw new BizException(ERRORCODE.AUTHCODE_EXIST.getCode(), ERRORCODE.AUTHCODE_EXIST.getMessage());
        }
        // 设置操作代码
        param.setCode(CommonUtils.getUUID());
        param.setCreateDate(System.currentTimeMillis());
        param.setCreator(currentUser.getUid());
        param.setStatus(DataStatusEnum.ENABLED.getValue());
        //保存操作
        if (this.insertMap(param.toMap()) > 0) {
            return RETURNCODE.ADD_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String update(AuthOperationParam param, AccountDto currentUser) {
        // 判断更新的操作名称是否冲突，操作名称唯一
        AuthOperation operation = this.findOne(AuthOperationParam.F_Name, param.getName());
        if (operation != null && !Objects.equals(operation.getId(), param.getId())){
            throw new BizException(ERRORCODE.OPERATION_EXIST.getCode(), ERRORCODE.OPERATION_EXIST.getMessage());
        }
        // 判断更新的操作的权限代码是否冲突，操作权限代码唯一
        operation = this.findOne(AuthOperationParam.F_AuthCode, param);
        if (operation != null && !Objects.equals(operation.getId(), param.getId())){
            throw new BizException(ERRORCODE.AUTHCODE_EXIST.getCode(), ERRORCODE.AUTHCODE_EXIST.getMessage());
        }
        //设置参数
        param.setLastModDate(System.currentTimeMillis());
        param.setLastModifier(currentUser.getUid());
        // 更新
        if(this.updateMap(param.toMap()) > 0){
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String disableOrEnable(long id, AccountDto currentUser) {
        AuthOperation queryOperation = this.findOne(AuthOperationParam.F_ID, id);
        int status = queryOperation.getStatus() == 0 ? 1 : 0;
        AuthModule authModule = authModuleDAO.findOne(AuthModuleParam.F_Code, queryOperation.getModuleCode(), null, null);
        if(status ==0 && authModule.getStatus() == 1){
            throw new BizException(ERRORCODE.ENABLE_EXC.getCode(), ERRORCODE.ENABLE_EXC.getMessage()+ "所属模块已停用，请启用后再试！");
        }
        queryOperation.setStatus(status);
        queryOperation.setLastModifier(currentUser.getUid());
        queryOperation.setLastModDate(System.currentTimeMillis());
        if(this.update(queryOperation) > 0){
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public Map<String, List<String>> getOperation(String uid, String roleCode) {
        List<AuthOperation> authOperations ;
        if(authRoleService.isSuper(uid)){
            authOperations = this.findList(AuthOperationParam.F_Status, DataStatusEnum.ENABLED);
        }else {
            authOperations = authOperationDAO.queryOperationsByUser(uid, roleCode, null, null);
        }
        List<AuthModule> modules = authModuleDAO.queryModulesByUser(uid, roleCode);
        if(modules.size() > 1){
            Collections.sort(modules, new Comparator<AuthModule>() {
                @Override
                public int compare(AuthModule a1, AuthModule o2) {
                    if(Objects.equals(a1.getLevel(), o2.getLevel())){
                        return a1.getPriority().compareTo(o2.getPriority());
                    }else{
                        return a1.getLevel().compareTo(o2.getLevel());
                    }
                }
            });
        }
        Map<String, List<String>> result = new HashMap<>();
        for(AuthModule authModule : modules){
            result.put(authModule.getUrl(), getAuthCodeListByModuleCode(authModule.getCode(), authOperations));
        }
        return result;
    }
    private List<String> getAuthCodeListByModuleCode(String moduleCode, List<AuthOperation> authOperations){
        List<String> authCodes = new ArrayList<>();
        for(AuthOperation authOperation: authOperations){
            if(moduleCode.equals(authOperation.getModuleCode())){
                authCodes.add(authOperation.getAuthCode());
            }
        }
        return authCodes;
    }
}