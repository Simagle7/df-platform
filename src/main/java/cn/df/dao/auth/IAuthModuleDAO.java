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

package cn.df.dao.auth;

import cn.df.dao.IDFBaseDAO;
import cn.df.domain.auth.AuthModule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 《权限模块》 数据访问接口
 *
 * @author Katybaby
 */
public interface IAuthModuleDAO extends IDFBaseDAO<AuthModule> {

    /**
     * 启用、停用模块节点
     *
     * @param pCode        父code
     * @param status       状态，0：启用，1：停用
     * @param lastModifier 更新者uid
     * @param lasModDate   更新时间
     * @return 返回，操作条数，非零：成功，0：失败
     */
    int updateStatus(@Param("pCode") String pCode, @Param("status") int status, @Param("lastModifier") String lastModifier, @Param("lastModDate") long lasModDate);

    /**
     * 根据用户uid和角色代码查询用户操作模块
     * @param uid       用户uid
     * @param roleCode  角色代码
     * @return  返回，模块列表集合
     */
    List<AuthModule> queryModulesByUser(@Param("uid") String uid, @Param("roleCode") String roleCode);
}