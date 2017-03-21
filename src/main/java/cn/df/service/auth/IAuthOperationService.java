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

package cn.df.service.auth;

import cn.df.common.domain.BaseDomain;
import cn.df.common.domain.BizData4Page;
import cn.df.common.dto.user.AccountDto;
import cn.df.dao.IDFBaseDAO;
import cn.df.param.auth.AuthOperationParam;
import cn.df.service.IDFBaseService;

import java.util.List;
import java.util.Map;

/**
 * 《权限操作》 业务逻辑服务接口
 *
 * @author Katybaby
 */
public interface IAuthOperationService<D extends IDFBaseDAO<T>, T extends BaseDomain> extends IDFBaseService<D, T> {

    /**
     * 分页查询操作列表
     *
     * @param param    查询参数
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return 返回，分页结果
     */
    BizData4Page queryPage(AuthOperationParam param, int pageNo, int pageSize);

    /**
     * 单个添加操作
     *
     * @param param       操作新增参数
     * @param currentUser 当前操作者
     * @return 返回，操作码
     */
    String add(AuthOperationParam param, AccountDto currentUser);

    /**
     * 更新操作
     * @param param         操作更新参数
     * @param currentUser   当前操作者
     * @return 返回，操作码
     */
    String update(AuthOperationParam param, AccountDto currentUser);

    /**
     * 停用启用操作
     * @param id            操作id
     * @param currentUser   当前操作者
     * @return  返回，操作码
     */
    String disableOrEnable(long id, AccountDto currentUser);

    /**
     * 获取用户当前身份的操作列表
     * @param uid  用户code
     * @return 返回，获取操作列表
     */
    Map<String,List<String>> getOperation(String uid, String roleCode);
}