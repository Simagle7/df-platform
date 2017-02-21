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

package cn.df.domain.auth;

import cn.df.common.domain.CreateBaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《权限控制》 实体
 * @author Katybaby
 *
 */
public class AuthAcl extends CreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private Integer subjectType; //主体类型（0：角色）
	private String subjectCode; //主体代码
	private Integer resourceType; //资源类型（0：模块，1：操作）
	private String resourceCode; //资源代码
    
	/**
	 *默认空构造函数
	 */
	public AuthAcl() {
		super();
	}
	 
	/**
	 * @return subjectType 主体类型（0：角色）
	 */
	public Integer getSubjectType(){
		return this.subjectType;
	}
	/**
	 * @param subjectType 主体类型（0：角色）
	 */
	public void setSubjectType(Integer subjectType){
		this.subjectType = subjectType;
	}
	/**
	 * @return subjectCode 主体代码
	 */
	public String getSubjectCode(){
		return this.subjectCode;
	}
	/**
	 * @param subjectCode 主体代码
	 */
	public void setSubjectCode(String subjectCode){
		this.subjectCode = subjectCode;
	}
	/**
	 * @return resourceType 资源类型（0：模块，1：操作）
	 */
	public Integer getResourceType(){
		return this.resourceType;
	}
	/**
	 * @param resourceType 资源类型（0：模块，1：操作）
	 */
	public void setResourceType(Integer resourceType){
		this.resourceType = resourceType;
	}
	/**
	 * @return resourceCode 资源代码
	 */
	public String getResourceCode(){
		return this.resourceCode;
	}
	/**
	 * @param resourceCode 资源代码
	 */
	public void setResourceCode(String resourceCode){
		this.resourceCode = resourceCode;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("subjectType",getSubjectType())
			.append("subjectCode",getSubjectCode())
			.append("resourceType",getResourceType())
			.append("resourceCode",getResourceCode())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getSubjectType())
			.append(getSubjectCode())
			.append(getResourceType())
			.append(getResourceCode())
			.append(getCreator())
			.append(getCreateDate())
			.append(getLastModifier())
			.append(getLastModDate())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AuthAcl == false) return false;
		if(this == obj) return true;
		AuthAcl other = (AuthAcl)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}
