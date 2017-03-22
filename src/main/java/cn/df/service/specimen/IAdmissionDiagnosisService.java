/*
{*****************************************************************************
{  疾病预测 v1.0													
{  版权信息 (c) 2005-2017 Katybaby. 保留所有权利.
{  创建人：  Katybaby
{  审查人：
{  模块：入院症见表											
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
import cn.df.dao.IDFBaseDAO;
import cn.df.service.IDFBaseService;

 /**
 * 《入院症见》 业务逻辑服务接口
 * @author Katybaby
 *
 */
public interface IAdmissionDiagnosisService<D extends IDFBaseDAO<T>, T extends BaseDomain> extends IDFBaseService<D, T>{

}