/*
{*****************************************************************************
{  疾病预测 v1.0													
{  版权信息 (c) 2005-2017 katybaby. 保留所有权利.
{  创建人：  katybaby
{  审查人：
{  模块：用户基础表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2017-02-20  katybaby        新建	
{ 	                                                                     
{*****************************************************************************
*/

package cn.df.dao.user;

import cn.df.dao.IDFBaseDAO;
import cn.df.domain.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 《用户基础》 数据访问接口
 * @author katybaby
 *
 */
public interface IUserDAO extends IDFBaseDAO<User> {


    /**
     * 分页查询用户列表
     * @param condition     查询条件
     * @param offset        偏移量
     * @param rows          页大小
     * @return  返回，分页列表
     */
     List<User> queryPageEx(@Param("condition") Map<String, Object> condition, @Param("offset") Integer offset, @Param("rows") Integer rows);

    /**
     * 统计分页
     * @param condition     查询条件
     * @return  返回，统计结果
     */
    int countEx(@Param("condition") Map<String, Object> condition);
}