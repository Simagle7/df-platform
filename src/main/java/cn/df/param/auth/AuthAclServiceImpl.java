/*
{*****************************************************************************
{  疾病预测 v1.0													
{  版权信息 (c) 2005-2017 Katybaby. 保留所有权利.
{  创建人：  Katybaby
{  审查人：
{  模块：权限控制表											
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

package cn.df.param.auth;

import cn.df.dao.IDFBaseDAO;
import cn.df.dao.auth.IAuthAclDAO;
import cn.df.domain.auth.AuthAcl;
import cn.df.service.AbstractDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 /**
 * 《权限控制》 业务逻辑服务类
 * @author Katybaby
 *
 */
@Service("AuthAclServiceImpl")
public class    AuthAclServiceImpl extends AbstractDFService<IDFBaseDAO<AuthAcl>, AuthAcl> implements cn.df.service.IDFBaseService<IDFBaseDAO<AuthAcl>,AuthAcl> {
    @Autowired
    private IAuthAclDAO authAclDAO;

    @Override
    public IDFBaseDAO<AuthAcl> getDao() {
        return authAclDAO;
    }

}