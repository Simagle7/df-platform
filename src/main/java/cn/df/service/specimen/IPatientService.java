/*
{*****************************************************************************
{  疾病预测 v1.0													
{  版权信息 (c) 2005-2017 Katybaby. 保留所有权利.
{  创建人：  Katybaby
{  审查人：
{  模块：病人表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2017-03-22  Katybaby        新建	
{ 	                                                                     
{*****************************************************************************
*/

package cn.df.service.specimen;

import cn.df.common.domain.BaseDomain;
import cn.df.common.domain.BizData4Page;
import cn.df.common.dto.user.AccountDto;
import cn.df.dao.IDFBaseDAO;
import cn.df.param.specimen.PatientParam;
import cn.df.param.specimen.PatientParamEx;
import cn.df.service.IDFBaseService;

/**
 * 《病人》 业务逻辑服务接口
 *
 * @author Katybaby
 */
public interface IPatientService<D extends IDFBaseDAO<T>, T extends BaseDomain> extends IDFBaseService<D, T> {


    /**
     * 分页查询病人
     * @param param     查询参数
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return  返回，分页结果
     */
    BizData4Page queryPage(PatientParamEx param, int pageNo, int pageSize);

    /**
     * 添加一条病人基础信息
     * @param param         添加参数
     * @return 返回，操作码
     */
    String add(PatientParam param);

    /**
     * 更新一条病人信息
     * @param param         更新参数
     * @param currentUser   当前操作用户
     * @return  返回，操作码
     */
    String update(PatientParam param, AccountDto currentUser);


}