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

package cn.df.dao.auth;

import cn.df.dao.IDFBaseDAO;
import cn.df.domain.auth.AuthRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 《权限角色》 数据访问接口
 * @author Katybaby
 *
 */
public interface IAuthRoleDAO extends IDFBaseDAO<AuthRole> {


    /**
     * 分页查询权限角色
     * @param condition     查询条件
     * @param offset        偏移量
     * @param rows      页大小
     * @return  返回，分页结果
     */
     List<AuthRole> queryPageEx(@Param("condition") Map<String, Object> condition, @Param("offset") Integer offset, @Param("rows") Integer rows);

    /**
     * 统计分页列表总数
     * @return
     */
     Integer countEx(@Param("condition")Map<String, Object> condition);

    /**
     * 根据用户uid判断用户是否具有超级管理员角色
     * @param uid   用户uid
     * @return  返回，角色实体
     */
    AuthRole hasSuper(@Param("usercode") String uid);

    /**
     * 根据用户代码查询用户角色列表
     * @param userCode      用户代码
     * @return  返回，用户实体
     */
    List<AuthRole> queryRoles4User(String userCode);
}