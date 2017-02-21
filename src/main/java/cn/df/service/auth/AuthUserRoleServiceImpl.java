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

import cn.df.common.domain.BaseDomain;
import cn.df.dao.IDFBaseDAO;
import cn.df.dao.auth.IAuthUserRoleDAO;
import cn.df.domain.auth.AuthUserRole;
import cn.df.service.auth.IAuthUserRoleService;
import cn.df.service.AbstractDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public IDFBaseDAO<AuthUserRole> getDao() {
        return authUserRoleDAO;
    }

}