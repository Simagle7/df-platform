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

package cn.df.param.specimen;

/**
 * 《病人》 查询参数实体
 * @author Katybaby
 *
 */
public class PatientParamEx extends PatientParam {
	private static final long serialVersionUID = 1L;

	private Integer minAge;
	private Integer maxAge;
	//针对PatientParam实体在这里增加额外的属性和对应的get和set方法


	public Integer getMinAge() {
		return minAge;
	}

	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}
}