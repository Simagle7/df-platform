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

import cn.df.common.domain.BaseDomain;
import cn.df.dao.IDFBaseDAO;
import cn.df.dao.auth.IAuthOperationDAO;
import cn.df.domain.auth.AuthOperation;
import cn.df.service.auth.IAuthOperationService;
import cn.df.service.AbstractDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

 /**
 * 《权限操作》 业务逻辑服务类
 * @author Katybaby
 *
 */
@Service("AuthOperationServiceImpl")
public class AuthOperationServiceImpl extends AbstractDFService<IDFBaseDAO<AuthOperation>, AuthOperation> implements IAuthOperationService<IDFBaseDAO<AuthOperation>,AuthOperation>{
    @Autowired
    private IAuthOperationDAO authOperationDAO;

    @Override
    public IDFBaseDAO<AuthOperation> getDao() {
        return authOperationDAO;
    }

}