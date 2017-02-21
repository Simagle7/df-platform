/*
{*****************************************************************************
{  疾病预测 v1.0													
{  版权信息 (c) 2005-2017 Katybaby. 保留所有权利.
{  创建人：  Katybaby
{  审查人：
{  模块：权限角色表											
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
import cn.df.common.shiro.DfRealm;
import cn.df.common.utils.base.DataStatusEnum;
import cn.df.common.utils.base.ERRORCODE;
import cn.df.common.utils.base.RETURNCODE;
import cn.df.common.utils.sys.CommonUtils;
import cn.df.common.utils.sys.PageUtils;
import cn.df.dao.IDFBaseDAO;
import cn.df.dao.auth.*;
import cn.df.domain.auth.*;
import cn.df.param.auth.AuthAclParam;
import cn.df.param.auth.AuthRoleParam;
import cn.df.param.auth.AuthUserRoleParam;
import cn.df.service.AbstractDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * 《权限角色》 业务逻辑服务类
 * @author Katybaby
 *
 */
@Service("AuthRoleServiceImpl")
public class AuthRoleServiceImpl extends AbstractDFService<IDFBaseDAO<AuthRole>, AuthRole> implements IAuthRoleService<IDFBaseDAO<AuthRole>,AuthRole>{

    @Autowired
    private IAuthRoleDAO authRoleDAO;
    @Autowired
    private IAuthAclDAO authAclDAO;
    @Autowired
    private IAuthUserRoleDAO authUserRoleDAO;
    @Autowired
    private IAuthModuleDAO authModuleDAO;
    @Autowired
    private IAuthOperationDAO authOperationDAO;
    @Autowired
    private DfRealm dfRealm;

    @Override
    public IDFBaseDAO<AuthRole> getDao() {
        return authRoleDAO;
    }

    @Override
    public BizData4Page queryPage(AuthRoleParam param, Integer pageNo, Integer pageSize) {
        //查询分页结果集
        List data = authRoleDAO.queryPageEx(param.toMap(),(pageNo-1)*pageSize, pageSize);

        //查询分页总数
        int records = authRoleDAO.countEx(param.toMap());

        //将分页结果封装并返回
        return PageUtils.toBizData4Page(data, pageNo, pageSize, records);
    }

    @Override
     public String add(AuthRoleParam param, AccountDto currentUser) {
        //判断是否为默认角色，如果是默认角色则不让插入（系统默认角色只能有一个）
         if(param.getIsDefault()&& this.isExists(AuthRoleParam.F_IsDefault, param.getIsDefault())){
             throw new BizException(ERRORCODE.DEFAULT_ROLE_EXIST.getCode(), ERRORCODE.DEFAULT_ROLE_EXIST.getMessage());
         }

         //判断角色是否重名，角色名称要求唯一
         AuthRole queryRole = this.findOne(AuthRoleParam.F_Name, param.getName());
         if(queryRole != null){
             throw new BizException(ERRORCODE.ROLE_EXIST.getCode(), ERRORCODE.ROLE_EXIST.getMessage());
         }

         param.setCreator(currentUser.getUid());
         param.setCreateDate(System.currentTimeMillis());
         param.setStatus(DataStatusEnum.ENABLED.getValue());
         param.setCode(CommonUtils.getUUID());
         //插入角色
         if (this.insertMap(param.toMap()) != 0) {
             return RETURNCODE.ADD_COMPLETE.getMessage();
         }
         throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
     }

    @Override
    public String update(AuthRoleParam param, AccountDto currentUser) {
        //查询是不是默认角色，如果是这抛出异常不给插入（默认角色只有一个）
        if(param.getIsDefault()&& this.isExists(AuthRoleParam.F_IsDefault, param.getIsDefault())){
            throw new BizException(ERRORCODE.DEFAULT_ROLE_EXIST.getCode(), ERRORCODE.DEFAULT_ROLE_EXIST.getMessage());
        }

        //查询角色名称是不是存在，角色名存在不准插入
        AuthRole queryRole = this.findOne(AuthRoleParam.F_Name, param.getName());
        if(queryRole != null && !queryRole.getCode().equals(param.getCode())){
            throw new BizException(ERRORCODE.ROLE_EXIST.getCode(), ERRORCODE.ROLE_EXIST.getMessage());
        }

        param.setCreateDate(System.currentTimeMillis());
        param.setCreator(currentUser.getUid());
        param.setStatus(0);

        //更新角色
        if(authRoleDAO.updateMap(param.toMap()) >0){
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String disableOrEnable(AuthRoleParam param, AccountDto currentUser) {
        param.setLastModDate(System.currentTimeMillis());
        param.setLastModifier(currentUser.getUid());
        if (this.updateMap(param.toMap()) > 0){
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String deleteOne(Long id, String roleCode) {
        //先删除角色对应的权限（操作）
        authAclDAO.deleteByProperty(AuthAclParam.F_SubjectCode, roleCode);
        //删除用户-角色
        authUserRoleDAO.deleteByProperty(AuthUserRoleParam.F_Rolecode, roleCode);
        //删除角色
        if(this.deleteById(id) > 0){
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String deleteByIds(List<Long> ids, List<String> roleCodes) {
        //删除角色对应的权限（操作）
        authAclDAO.deleteBatchByProperty(AuthAclParam.F_SubjectCode, CommonUtils.transList(roleCodes));
        //删除角色-用户
        authUserRoleDAO.deleteBatchByProperty(AuthUserRoleParam.F_Rolecode, CommonUtils.transList(roleCodes));
        if(this.deleteByIds(ids) >0){
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public List<AuthTreeNode> queryModuleAndOperation() {
        //查询出所有模块
        List<AuthModule> authModules = authModuleDAO.findAll(null, null);
        //查询出所有的操作
        List<AuthOperation> authOperations = authOperationDAO.findAll(null, null);
        List<AuthTreeNode> result = new ArrayList<>();
        List<String> moduleCodes = new ArrayList<>();
        for(AuthModule authModule : authModules){
            moduleCodes.add(authModule.getCode());
            String moduleName = authModule.getName();
            if(authModule.getStatus() == 1){
                moduleName += "【已停用】";
            }
            AuthTreeNode authTreeNode = new AuthTreeNode(authModule.getCode(), moduleName, authModule.getPCode(), true);
            result.add(authTreeNode);
        }
        for (AuthOperation authOperation: authOperations){
            if(moduleCodes.contains(authOperation.getModuleCode())){
                String oprationName = authOperation.getName();
                if(authOperation.getStatus() == 1){
                    oprationName += "【已停用】";
                }
                AuthTreeNode authTreeNode = new AuthTreeNode(authOperation.getCode(), oprationName, authOperation.getModuleCode(), false);
                //添加到前面（树形结构）
                result.add(0, authTreeNode);
            }
        }
        return result;
    }

    @Override
    public String saveAuth(String roleCode, String[] moduleCodes, String[] operationCodes, AccountDto accountDto) {
        //对象封装
        List<AuthAcl> authAcls = new ArrayList<>();
        for(String code: moduleCodes){
            AuthAcl authAcl = new AuthAcl();
            authAcl.setSubjectType(0);
            authAcl.setSubjectCode(roleCode);
            authAcl.setResourceType(0);
            authAcl.setResourceCode(code);
            authAcl.setStatus(0);
            authAcl.setCreator(accountDto.getUid());
            authAcl.setCreateDate(System.currentTimeMillis());
            authAcls.add(authAcl);
        }
        for (String code: operationCodes){
            AuthAcl authAcl = new AuthAcl();
            authAcl.setSubjectType(0);
            authAcl.setSubjectCode(roleCode);
            authAcl.setResourceType(1);
            authAcl.setResourceCode(code);
            authAcl.setStatus(0);
            authAcl.setCreator(accountDto.getUid());
            authAcl.setCreateDate(System.currentTimeMillis());
            authAcls.add(authAcl);
        }
        //组装删除参数
        AuthAclParam authAclParam = new AuthAclParam();
        authAclParam.setSubjectType(0);
        authAclParam.setSubjectCode(roleCode);
        //先删除后再添加
        authAclDAO.deleteByCondition(authAclParam.toMap());
        if(authAcls.size() > 0){
            authAclDAO.insertBatch(authAcls);
        }
        //更新系统权限
        dfRealm.clearCahced();

        return RETURNCODE.AUTH_SUCCESS.getMessage();
    }
}