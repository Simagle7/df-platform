/*
{*****************************************************************************
{  疾病预测 v1.0													
{  版权信息 (c) 2005-2017 Katybaby. 保留所有权利.
{  创建人：  Katybaby
{  审查人：
{  模块：用户角色表											
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

import cn.df.common.dto.user.AccountDto;
import cn.df.common.exception.BizException;
import cn.df.common.utils.base.DataStatusEnum;
import cn.df.common.utils.base.ERRORCODE;
import cn.df.common.utils.base.RETURNCODE;
import cn.df.common.utils.base.SqlOrderEnum;
import cn.df.dao.IDFBaseDAO;
import cn.df.dao.auth.IAuthRoleDAO;
import cn.df.dao.auth.IAuthUserRoleDAO;
import cn.df.domain.auth.AuthRole;
import cn.df.domain.auth.AuthUserRole;
import cn.df.param.auth.AuthRoleParam;
import cn.df.param.auth.AuthUserRoleParam;
import cn.df.service.AbstractDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 《用户角色》 业务逻辑服务类
 * @author Katybaby
 *
 */
@Service("AuthUserRoleServiceImpl")
public class AuthUserRoleServiceImpl extends AbstractDFService<IDFBaseDAO<AuthUserRole>, AuthUserRole> implements IAuthUserRoleService<IDFBaseDAO<AuthUserRole>,AuthUserRole>{
    @Autowired
    private IAuthUserRoleDAO authUserRoleDAO;
    @Autowired
    private IAuthRoleDAO authRoleDAO;

    @Override
    public IDFBaseDAO<AuthUserRole> getDao() {
        return authUserRoleDAO;
    }

     @Override
     public Map<String, Object> queryRolesForAuth(String uid, Boolean isNeedDefault) {
         AuthRoleParam authRoleParam = new AuthRoleParam();
         authRoleParam.setStatus(DataStatusEnum.ENABLED.getValue());
         authRoleParam.setIsDefault(null);
//         if(!isNeedDefault){
//             authRoleParam.setIsDefault(isNeedDefault);
//         }

         //获取所有的角色（不包括默认角色）
         List<AuthRole> authRoleList = authRoleDAO.queryList(authRoleParam.toMap(), AuthRoleParam.F_CreateDate, SqlOrderEnum.ASC.getAction());
         List<String> roleCodes = authUserRoleDAO.querySelectedRoles(uid);
         Map<String, Object> result = new HashMap<>();
         result.put("allRole", authRoleList);
         result.put("selected", roleCodes);
         return result;
     }

     @Override
     public String save(String uid, String[] roleCodes, AccountDto currentUser) {
         //删除之前的记录
         AuthUserRoleParam param = new AuthUserRoleParam();
         param.setUsercode(uid);
         this.deleteByCondition(param.toMap());
         List<AuthUserRole> authRoleUsers = new ArrayList<>();
         AuthUserRole authRoleUser;
         for(String roleCode: roleCodes){
             authRoleUser = new AuthUserRole();
             authRoleUser.setUsercode(uid);
             authRoleUser.setRolecode(roleCode);
             authRoleUser.setCreator(currentUser.getUid());
             authRoleUser.setCreateDate(System.currentTimeMillis());
             authRoleUser.setStatus(DataStatusEnum.ENABLED.getValue());
             authRoleUsers.add(authRoleUser);
         }
         if(authUserRoleDAO.insertBatch(authRoleUsers) > 0){
             return RETURNCODE.ADD_COMPLETE.getMessage();
         }
         throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
     }
 }