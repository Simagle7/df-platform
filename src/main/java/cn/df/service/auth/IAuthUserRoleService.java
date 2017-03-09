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
import cn.df.common.dto.user.AccountDto;
import cn.df.dao.IDFBaseDAO;
import cn.df.service.IDFBaseService;

import java.util.Map;

/**
 * 《用户角色》 业务逻辑服务接口
 * @author Katybaby
 *
 */
public interface IAuthUserRoleService<D extends IDFBaseDAO<T>, T extends BaseDomain> extends IDFBaseService<D, T>{

     Map<String,Object> queryRolesForAuth(String uid,  Boolean isNeedDefault);

    /**
     * 保存用户角色关系（赋予用户角色）
     * @param uid           用户uid
     * @param roleCodes     角色代码集合
     * @param currentUser   当前操作用户
     * @return  返回，操作码
     */
    String save(String uid, String[] roleCodes, AccountDto currentUser);
}