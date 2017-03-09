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

package cn.df.service.user;

import cn.df.common.domain.BaseDomain;
import cn.df.common.domain.BizData4Page;
import cn.df.common.dto.user.AccountDto;
import cn.df.dao.IDFBaseDAO;
import cn.df.param.user.UserParam;
import cn.df.param.user.UserParamEx;
import cn.df.service.IDFBaseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 《用户基础》 业务逻辑服务接口
 * @author katybaby
 *
 */
public interface IUserService<D extends IDFBaseDAO<T>, T extends BaseDomain> extends IDFBaseService<D, T>{


    /**
     * 判断用户登录状态
     * @param request       请求流
     * @param response      响应流
     * @return  返回，成功：返回用户代码，失败：返回操作码
     */
     String isLogin(HttpServletRequest request, HttpServletResponse response);
     /**
      * 分页查询
      * @param param      查询参数
      * @param pageNo     页码
      * @param pageSize   页大小
      * @return 返回，分页结果
      */
      BizData4Page queryPage(UserParam param, Integer pageNo, Integer pageSize);

     /**
      * 添加一个用户
      * @param param        用户参数
      * @param currentUser  当前操作用户
      * @return 返回，操作码
      */
     String add(UserParam param, AccountDto currentUser);

     /**
      * 更新一个用户
      * @param param        用户参数
      * @param currentUser  当前操作用户
      * @return 返回，操作码
      */
     String update(UserParam param, AccountDto currentUser);

     /**
      * 忘记密码
      * @param paramEx      修改参数
      * @param currentUser  当前参数
      * @return 返回，操作码
      */
     String forgetPassword(UserParamEx paramEx, AccountDto currentUser);

     /**
      * 重置用户密码
      * @param param        重置参数
      * @param currentUser  当前操作用户
      * @return 返回，重置后的用户密码
      */
     String resetPassword(UserParam param, AccountDto currentUser);

     /**
      * 停用和启用网站
      * @param param        参数
      * @param currentUser  当前操作用户
      * @return 返回，操作码
      */
     String disabledOrEnabled(UserParam param, AccountDto currentUser);

     /**
      * 初始化用户信息
      * @param userCode  用户代码
      * @param roleCode  角色代码
      * @return 返回，用户实体信息
      */
     AccountDto initUser(String userCode, String roleCode);
}