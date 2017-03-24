/*
{*****************************************************************************
{  疾病预测 v1.0													
{  版权信息 (c) 2005-2017 Katybaby. 保留所有权利.
{  创建人：  Katybaby
{  审查人：
{  模块：权限模块表											
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
import cn.df.common.domain.SearchField;
import cn.df.common.dto.user.AccountDto;
import cn.df.common.exception.BizException;
import cn.df.common.utils.auth.AuthUtils;
import cn.df.common.utils.base.ERRORCODE;
import cn.df.common.utils.base.RETURNCODE;
import cn.df.common.utils.sys.CommonUtils;
import cn.df.common.utils.sys.PageUtils;
import cn.df.dao.IDFBaseDAO;
import cn.df.dao.auth.IAuthAclDAO;
import cn.df.dao.auth.IAuthModuleDAO;
import cn.df.dao.auth.IAuthOperationDAO;
import cn.df.domain.auth.AuthModule;
import cn.df.domain.auth.AuthOperation;
import cn.df.param.auth.AuthAclParam;
import cn.df.param.auth.AuthModuleParam;
import cn.df.param.auth.AuthOperationParam;
import cn.df.service.AbstractDFService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 《权限模块》 业务逻辑服务类
 * @author Katybaby
 *
 */
@Service("AuthModuleServiceImpl")
public class AuthModuleServiceImpl extends AbstractDFService<IDFBaseDAO<AuthModule>, AuthModule> implements IAuthModuleService<IDFBaseDAO<AuthModule>,AuthModule>{
    @Autowired
    private IAuthModuleDAO authModuleDAO;
    @Autowired
    private IAuthOperationDAO authOperationDAO;
    @Autowired
    private IAuthAclDAO authAclDAO;

    @Override
    public IDFBaseDAO<AuthModule> getDao() {
        return authModuleDAO;
    }

     @Override
     public BizData4Page queryPage(AuthModuleParam param, Integer pageNo, Integer pageSize) {
         Map<String, Object> condition = param.toSearchFieldMap();
         //模块名称模糊查询
         if (condition.containsKey(AuthModuleParam.F_Name)) {
             condition.put(AuthModuleParam.F_Name, new SearchField(AuthModuleParam.F_Name, "like", "%" + param.getName() + "%"));
         }
         //根据code查询符合的fullCode，把其子节点列出来
         if (condition.containsKey(AuthModuleParam.F_Code)) {
             condition.remove(AuthModuleParam.F_Code);
             condition.put(AuthModuleParam.F_FullCode, new SearchField(AuthModuleParam.F_FullCode, "like", "%" + param.getCode() + "%"));
         }
         List data = this.queryPage(condition, (pageNo - 1) * pageSize, pageSize);
         int records = this.count(condition);
         return PageUtils.toBizData4Page(data, pageNo, pageSize, records);
     }

     @Override
     public String add(AuthModuleParam param, AccountDto currentUser) {
         //判断传入的url不为空并且唯一
         if (!StringUtils.isEmpty(param.getUrl()) && isExists(AuthModuleParam.F_Url, param.getUrl())) {
             throw new BizException(ERRORCODE.MODULEURL_EXIST.getCode(), "模块" + ERRORCODE.MODULEURL_EXIST.getMessage());
         }
         //设置code
         param.setCode(CommonUtils.getUUID());
         //查询父节点
         AuthModule p_authModule = this.findOne(AuthModuleParam.F_Code, param.getpCode());
         if (p_authModule == null) {
             param.setPid(0L);
//             param.setPCode("0");
             param.setFullCode("0." + param.getCode());
             param.setFullName(param.getName());
             param.setStatus(0);
         } else {
             param.setPid(p_authModule.getId());
//             param.setPCode(p_authModule.getCode());
             param.setFullCode(p_authModule.getFullCode() + "." + param.getCode());
             param.setFullName(p_authModule.getFullName() + "|" + param.getName());
             param.setStatus(p_authModule.getStatus());
         }
         param.setCreator(currentUser.getUid());
         param.setCreateDate(System.currentTimeMillis());

         if (this.insertMap(param.toMap()) > 0) {
             return RETURNCODE.ADD_COMPLETE.getMessage();
         }
         throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
     }

    @Override
    public List queryModules(Integer status) {
        List<AuthModule> authModuleList = this.findList(AuthModuleParam.F_Status, status);
        authModuleList = AuthUtils.buildAuthModuleTree(authModuleList, AuthUtils.AUTHROOTCODE, false);
        List<Map<String, Object>> result = new ArrayList<>();
        for (AuthModule authModule : authModuleList) {
            Map<String, Object> map = new HashMap<>();
            map.put(AuthModuleParam.F_Code, authModule.getCode());
            map.put(AuthModuleParam.F_Level, authModule.getLevel());
            map.put(AuthModuleParam.F_Name, "┠ " + StringUtils.repeat("─ ", authModule.getLevel() - 1) + authModule.getName());
            result.add(map);
        }
        return result;
    }

    @Override
    public List queryModulesNoChildren(String moduleFullCode) {
        List<AuthModule> authModuleList = this.findAll();
        authModuleList = AuthUtils.buildAuthModuleTree(authModuleList, AuthUtils.AUTHROOTCODE, false);
        List<Map<String, Object>> result = new ArrayList<>();
        for (AuthModule authModule : authModuleList) {
            if (authModule.getFullCode().startsWith(moduleFullCode)) {
                continue;
            }
            Map<String, Object> map = new HashMap<>();
            map.put(AuthModuleParam.F_Code, authModule.getCode());
            map.put(AuthModuleParam.F_Level, authModule.getLevel());
            map.put(AuthModuleParam.F_Name, "┠ " + StringUtils.repeat("─ ", authModule.getLevel() - 1) + authModule.getName());
            result.add(map);
        }
        return result;
    }

    @Override
    public String update(AuthModuleParam param, AccountDto currentUser) {
        //先把之前的查询出来
        AuthModule originAuthModule = this.findOne(AuthModuleParam.F_ID, param.getId());
        //查询是否存在重复的URL
        Boolean isExistUrl = isExists(AuthModuleParam.F_Url, param.getUrl());
        if (!StringUtils.isEmpty(param.getUrl()) && !originAuthModule.getUrl().equals(param.getUrl()) && isExistUrl) {
            throw new BizException(ERRORCODE.MODULEURL_EXIST.getCode(), "模块" + ERRORCODE.MODULEURL_EXIST.getMessage());
        }
        try {
            //查询父节点
            AuthModule p_authModule = this.findOne(AuthModuleParam.F_Code, param.getpCode());
            if (p_authModule == null) {
                param.setPid(0L);
                param.setFullCode("0." + param.getCode());
                param.setFullName(param.getName());
            } else {
                param.setPid(p_authModule.getId());
                param.setFullCode(p_authModule.getFullCode() + "." + param.getCode());
                param.setFullName(p_authModule.getFullName() + "|" + param.getName());
                param.setStatus(p_authModule.getStatus());
            }
            param.setLastModDate(System.currentTimeMillis());
            param.setLastModifier(currentUser.getUid());
            //更新自身
            if ( this.updateMap(param.toMap()) > 0){
                //更新子孙节点
                updateChild(originAuthModule, param, currentUser);
            }
        } catch (Exception e) {
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
        return RETURNCODE.UPDATE_COMPLETE.getMessage();
    }

    @Override
    public void updateChild(AuthModule originAuthModule, AuthModuleParam param, AccountDto accountDto) {
        //更新模块下的功能的状态
        if (!Objects.equals(originAuthModule.getStatus(), param.getStatus())) {
            updateOperationStatus(param.getStatus(), param.getCode(), accountDto.getUid());
        }
        //更新子节点的信息
        List<AuthModule> authModuleList = queryChildrenModules(originAuthModule.getFullCode());
        for (AuthModule authModule : authModuleList) {
            authModule.setFullCode(authModule.getFullCode().replace(originAuthModule.getFullCode(), param.getFullCode()));
            authModule.setFullName(authModule.getFullName().replace(originAuthModule.getFullName() + "|", param.getFullName() + "|"));
            authModule.setLevel(StringUtils.countMatches(authModule.getFullCode(), "."));
            authModule.setStatus(param.getStatus());
            this.update(authModule);
            //更新模块下的功能的状态
            if (!Objects.equals(originAuthModule.getStatus(), param.getStatus())) {
                updateOperationStatus(param.getStatus(), authModule.getCode(), accountDto.getUid());
            }
        }
    }

    @Override
    public String disableOrEnable(long id, AccountDto currentUser) {
        AuthModule queryAuthModule = this.findOne(AuthModuleParam.F_ID, id);
        //修改模块状态
        int status = queryAuthModule.getStatus() == 0 ? 1 : 0;
        //查看父节点状态
        AuthModule p_authModule = this.findOne(AuthModuleParam.F_Code, queryAuthModule.getPCode());
        if (p_authModule != null && status == 0 && p_authModule.getStatus() == 1) {
            throw new BizException(ERRORCODE.ENABLE_EXC.getCode(), ERRORCODE.ENABLE_EXC.getMessage() + "上级模块已停用，请启用后再试！");
        }
        //更新当前节点以及子孙节点状态
        authModuleDAO.updateStatus(queryAuthModule.getCode(), status, currentUser.getUid(), System.currentTimeMillis());
        //更新节点操作状态
        List<AuthModule> authModuleList = queryChildrenModules(queryAuthModule.getFullCode());
        for (AuthModule authModule : authModuleList) {
            updateOperationStatus(status, authModule.getCode(), currentUser.getUid());
        }
        return RETURNCODE.SUCCESS_COMPLETE.getMessage();
    }

    @Override
    public String deleteOne(long id) {
        AuthModule originAuthModule = this.findOne(AuthModuleParam.F_ID, id);
        if (originAuthModule != null) {
            List<AuthModule> authModuleList = queryChildrenModules(originAuthModule.getFullCode());
            List<Long> moduleIds = new ArrayList<>();
            List<String> moduleCodes = new ArrayList<>();
            List<Object> resourceCodes = new ArrayList<>();
            for (AuthModule authModule : authModuleList) {
                moduleIds.add(authModule.getId());
                moduleCodes.add(authModule.getCode());
                //查询对应模块的操作
                List<AuthOperation> authOperationList = authOperationDAO.findList(AuthOperationParam.F_ModuleCode, authModule.getCode(), null, null);
                for (AuthOperation authOperation : authOperationList) {
                    resourceCodes.add(authOperation.getCode());
                }
            }
            //删除模块对应的操作operation
            authOperationDAO.deleteOperationByCodes(moduleCodes);
            //删除acl中对应的模块+操作
            if (resourceCodes.size() > 0) {
                authAclDAO.deleteBatchByProperty(AuthAclParam.F_ResourceCode, resourceCodes);
            }
            //删除模块
            this.deleteByIds(moduleIds);
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    /**
     * 更新模块下对应的操作
     *
     * @param status     状态
     * @param moduleCode 模块code
     */
    private void updateOperationStatus(int status, String moduleCode, String uid) {
        Map<String, Object> updateMap = new HashMap<>();
        updateMap.put(AuthModuleParam.F_Status, status);
        Map<String, Object> conditionMap = new HashMap<>();
        conditionMap.put(AuthOperationParam.F_ModuleCode, moduleCode);
        conditionMap.put(AuthModuleParam.F_LastModifier, uid);
        conditionMap.put(AuthModuleParam.F_LastModDate, System.currentTimeMillis());
        authOperationDAO.updateByCondition(updateMap, conditionMap);
    }

    /**
     * 根据模块code获取子模块，包括自己
     *
     * @param fullCode 模块
     * @return 返回，模块列表
     */
    private List<AuthModule> queryChildrenModules(String fullCode) {
        Map<String, Object> condition = new HashMap<>();
        condition.put(AuthModuleParam.F_FullCode, new SearchField(AuthModuleParam.F_FullCode, "like", fullCode + "%"));
        return this.queryPage(condition, 0, Integer.MAX_VALUE);
    }

    @Override
    public List<AuthModule> getModules(String uid, String roleCode) {
        List<AuthModule> authModules = authModuleDAO.queryModulesByUser(uid, roleCode);
//        if (authRoleService.isSuper(uid, userType)) {
//            authModules = this.findList(AuthModuleParam.F_Status, DataStatusEnum.ENABLED);
//        } else {
//            authModules = this.queryModulesByUser(uid, userType, null, null);
//        }
        if(authModules.size() > 1){
            Collections.sort(authModules, new Comparator<AuthModule>() {
                @Override
                public int compare(AuthModule o1, AuthModule o2) {
                    if(Objects.equals(o1.getLevel(), o2.getLevel())){
                        return o1.getPriority().compareTo(o2.getPriority());
                    }else{
                        return o1.getLevel().compareTo(o2.getLevel());
                    }
                }
            });
        }
        return authModules;
    }
}