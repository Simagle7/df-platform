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
{  2017-03-24  Katybaby        新建	
{ 	                                                                     
{*****************************************************************************
*/

package cn.df.domain.specimen;

import cn.df.common.domain.BaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《病人》 实体
 * @author Katybaby
 *
 */
public class Patient extends BaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private Integer gender; //性别，0：男，1：女
	private Integer age; //年龄
	private String code; //病人代码，主键，为32位uuid
	private Integer isSicken; //是否患病，0：否，1：是
    
	/**
	 *默认空构造函数
	 */
	public Patient() {
		super();
	}
	 
	/**
	 * @return gender 性别，0：男，1：女
	 */
	public Integer getGender(){
		return this.gender;
	}
	/**
	 * @param gender 性别，0：男，1：女
	 */
	public void setGender(Integer gender){
		this.gender = gender;
	}
	/**
	 * @return age 年龄
	 */
	public Integer getAge(){
		return this.age;
	}
	/**
	 * @param age 年龄
	 */
	public void setAge(Integer age){
		this.age = age;
	}
	/**
	 * @return code 病人代码，主键，为32位uuid
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 病人代码，主键，为32位uuid
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return isSicken 是否患病，0：否，1：是
	 */
	public Integer getIsSicken(){
		return this.isSicken;
	}
	/**
	 * @param isSicken 是否患病，0：否，1：是
	 */
	public void setIsSicken(Integer isSicken){
		this.isSicken = isSicken;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("gender",getGender())
			.append("age",getAge())
			.append("code",getCode())
			.append("isSicken",getIsSicken())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getGender())
			.append(getAge())
			.append(getCode())
			.append(getIsSicken())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Patient == false) return false;
		if(this == obj) return true;
		Patient other = (Patient)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}
