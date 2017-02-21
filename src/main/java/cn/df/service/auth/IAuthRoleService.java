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

package cn.df.service.auth;

import cn.df.common.domain.BaseDomain;
import cn.df.common.domain.BizData4Page;
import cn.df.common.dto.user.AccountDto;
import cn.df.dao.IDFBaseDAO;
import cn.df.domain.auth.AuthTreeNode;
import cn.df.param.auth.AuthRoleParam;
import cn.df.service.IDFBaseService;

import java.util.List;

/**
 * 《权限角色》 业务逻辑服务接口
 * @author Katybaby
 *
 */
public interface IAuthRoleService<D extends IDFBaseDAO<T>, T extends BaseDomain> extends IDFBaseService<D, T>{


     /**
      * 分页查询角色
      * @param param        查询参数
      * @param pageNo       页码
      * @param pageSize     页大小
      * @return 返回，分页结果集
      */
    BizData4Page queryPage(AuthRoleParam param, Integer pageNo, Integer pageSize);
     /**
      * 添加权限角色
      * @param param     角色信息实体
      * @param currentUser  当前操作用户
      * @return 返回， 操作码
      */
     String add(AuthRoleParam param, AccountDto currentUser);

     /**
      * 更新权限角色
      * @param param        更新参数
      * @param currentUser  当前操作用户
      * @return 返回，操作码
      */
     String update(AuthRoleParam param, AccountDto currentUser);

     /**
      * 停用，启用角色
      * @param param        参数
      * @param currentUser  当前操作用户
      * @return 返回，操作码
      */
     String disableOrEnable(AuthRoleParam param, AccountDto currentUser);

     /**
      * 删除一个角色
      * @param id           角色id
      * @param roleCode     角色代码
      * @return 返回 ，操作码
      */
     String deleteOne(Long id, String roleCode);

    /**
     * 批量删除角色
     * @param ids           角色ids列表
     * @param roleCodes     角色代码集合
     * @return 返回，操作码
     */
     String deleteByIds(List<Long> ids, List<String> roleCodes);

    /**
     * 查询模块和操作树
     * @return 返回，模块和操作树
     */
    List<AuthTreeNode> queryModuleAndOperation();

    /**
     * 保存授权信息
     * @param roleCode          角色代码
     * @param moduleCodes       模块代码集合
     * @param operationCodes    操作代码集合
     * @param accountDto        当前操作者
     * @return  返回，操作码
     */
    String saveAuth(String roleCode, String[] moduleCodes, String[] operationCodes, AccountDto accountDto);
}