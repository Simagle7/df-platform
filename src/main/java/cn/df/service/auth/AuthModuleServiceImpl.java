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

import cn.df.common.domain.BaseDomain;
import cn.df.dao.IDFBaseDAO;
import cn.df.dao.auth.IAuthModuleDAO;
import cn.df.domain.auth.AuthModule;
import cn.df.service.auth.IAuthModuleService;
import cn.df.service.AbstractDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

 /**
 * 《权限模块》 业务逻辑服务类
 * @author Katybaby
 *
 */
@Service("AuthModuleServiceImpl")
public class AuthModuleServiceImpl extends AbstractDFService<IDFBaseDAO<AuthModule>, AuthModule> implements IAuthModuleService<IDFBaseDAO<AuthModule>,AuthModule>{
    @Autowired
    private IAuthModuleDAO authModuleDAO;

    @Override
    public IDFBaseDAO<AuthModule> getDao() {
        return authModuleDAO;
    }

}