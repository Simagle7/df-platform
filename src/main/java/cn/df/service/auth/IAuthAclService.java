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

package cn.df.service.auth;

import cn.df.common.domain.BaseDomain;
import cn.df.dao.IDFBaseDAO;
import cn.df.service.IDFBaseService;

import java.util.List;

/**
 * 《权限控制》 业务逻辑服务接口
 * @author Katybaby
 *
 */
public interface IAuthAclService<D extends IDFBaseDAO<T>, T extends BaseDomain> extends IDFBaseService<D, T>{

    /**
     * 查询资源code，角色回显
     * @param subjectType   主体类型，0：角色
     * @param subjectCode   主体代码
     * @return 返回，资源列表
     */
    List<String> queryResourceCode(Integer subjectType, String subjectCode);
 }