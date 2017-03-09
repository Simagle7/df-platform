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

package cn.df.dao.auth;

import cn.df.dao.IDFBaseDAO;
import cn.df.domain.auth.AuthOperation;
import cn.df.domain.auth.AuthOperationEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 《权限操作》 数据访问接口
 * @author Katybaby
 *
 */
public interface IAuthOperationDAO extends IDFBaseDAO<AuthOperation> {


    /**
     * 根据模块code删除操作
     * @param moduleCodes   模块code列表
     * @return  返回，非零：成功删除的记录数，0：失败
     */
    int deleteOperationByCodes(@Param("list") List<String> moduleCodes);

    /**
     * 分页查询权限模块
     * @param condition     查询条件
     * @param offset        偏移量
     * @param rows          行号
     * @return  返回，非零，分页列表
     */
    List<AuthOperationEx> queryPageEx(@Param("condition") Map<String, Object> condition,@Param("offset") int offset, @Param("rows") int rows);

    /**
     * 统计分页
     * @param condition  查询条件
     * @return  返回，统计总数
     */
    int countEx(@Param("condition") Map<String, Object> condition);

    /**
     * 获取用户当前角色下的操作列表
     * @param uid           用户uid
     * @param roleCode      角色代码
     * @param offset        偏移量
     * @param rows          行数
     * @return 返回， 权限列表
     */
    List<AuthOperation> queryOperationsByUser(@Param("userCode") String uid, @Param("roleCode") String roleCode, @Param("offset") Integer offset, @Param("rows") Integer rows);
}