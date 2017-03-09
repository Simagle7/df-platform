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

package cn.df.dao.auth;

import cn.df.dao.IDFBaseDAO;
import cn.df.domain.auth.AuthUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 《用户角色》 数据访问接口
 * @author Katybaby
 *
 */
public interface IAuthUserRoleDAO extends IDFBaseDAO<AuthUserRole> {


    /**
     * 根据字段批量删除
     * @param property  字段名
     * @param values    字段值
     * @return  返回，非零：删除的条数，0：失败
     */
    int deleteBatchByProperty(@Param("property") String property, @Param("list") List<Object> values);

    /**
     * 批量插入赋予用户角色（一次赋予用户多个角色）
     * @param authRoleUsers     关系集合
     * @return 返回，非零：成功插入条数，0：失败
     */
    int insertBatch(List<AuthUserRole> authRoleUsers);
}