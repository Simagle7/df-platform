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
import cn.df.common.domain.BizData4Page;
import cn.df.common.dto.user.AccountDto;
import cn.df.dao.IDFBaseDAO;
import cn.df.domain.auth.AuthModule;
import cn.df.param.auth.AuthModuleParam;
import cn.df.service.IDFBaseService;

import java.util.List;

/**
 * 《权限模块》 业务逻辑服务接口
 *
 * @author Katybaby
 */
public interface IAuthModuleService<D extends IDFBaseDAO<T>, T extends BaseDomain> extends IDFBaseService<D, T> {

    /**
     * 分页查询分页接口
     *
     * @param param    查询参数
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return 返回，分页列表
     */
    BizData4Page queryPage(AuthModuleParam param, Integer pageNo, Integer pageSize);

    /**
     * 新增一个模块
     * @param param    模块参数
     * @param currentUser   当前操作用用户
     * @return 返回，操作码
     */
    String add(AuthModuleParam param, AccountDto currentUser);

    /**
     * 获取模块列表
     * @param status    模块状态，0：启用，1：停用
     * @return  返回，模块树
     */
    List queryModules(Integer status);

    /**
     * 查询模块列表，（不出现子节点）
     * @param moduleFullCode    模块fullCode
     * @return 返回，模块树（不包含子节点）
     */
    List queryModulesNoChildren(String moduleFullCode);

    /**
     * 更新一个模块节点
     * @param param    模块参数
     * @param currentUser    操作者
     * @return  返回，操作码
     */
    String update(AuthModuleParam param, AccountDto currentUser);

    /**
     * 更新某个节点下的子孙节点
     * @param originAuthModule  原本的数据
     * @param param             更新的数据
     * @param accountDto        操作用户
     */
    void updateChild(AuthModule originAuthModule, AuthModuleParam param, AccountDto accountDto);

    /**
     * 启用停用模块
     * @param id            模块id
     * @param currentUser   当前操作者
     * @return 返回，操作码
     */
    String disableOrEnable(long id, AccountDto currentUser);

    /**
     * 删除一个模块
     * @param id    模块id
     * @return  返回操作码
     */
    String deleteOne(long id);

    /**
     * 根据用户uid获取用户模块
     * @param uid       用户uid
     * @param roleCode  角色代码
     * @return  返回，模块列表
     */
    List<AuthModule> getModules(String uid, String roleCode);
}