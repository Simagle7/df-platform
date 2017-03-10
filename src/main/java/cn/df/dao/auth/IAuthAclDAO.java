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

package cn.df.dao.auth;

import cn.df.dao.IDFBaseDAO;
import cn.df.domain.auth.AuthAcl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 《权限控制》 数据访问接口
 * @author Katybaby
 *
 */
public interface IAuthAclDAO extends IDFBaseDAO<AuthAcl> {

    /**
     * 根据某个字段批量删除数据
     * @param property      字段名
     * @param values        字段值
     * @return  返回，非零：删除的条数，0：失败
     */
    int deleteBatchByProperty(@Param("property") String property, @Param("list") List<Object> values);

    /**
     * 查询资源code用户回显
     *
     * @param subjectType 主体类型，0：角色
     * @param subjectCode 主体代码
     * @return 返回，资源列表
     */
    List<String> queryResourceCode(@Param("subjectType") Integer subjectType, @Param("subjectCode") String subjectCode);

    /**
     * 批量插入
     * @param authAcls  权限控制集合
     * @return  受影响行数
     */
    int insertBatch(@Param("authAclList") List<AuthAcl> authAcls);
}