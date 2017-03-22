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

package cn.df.dao.specimen;

import cn.df.dao.IDFBaseDAO;
import cn.df.domain.specimen.Patient;

 /**
 * 《病人》 数据访问接口
 * @author Katybaby
 *
 */
public interface IPatientDAO extends IDFBaseDAO<Patient> {

	Patient findBycode(String code);

}