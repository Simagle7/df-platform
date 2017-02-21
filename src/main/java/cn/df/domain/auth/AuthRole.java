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

package cn.df.domain.auth;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.df.common.domain.CreateBaseDomain;

import java.util.*;

/**
 * 《权限角色》 实体
 * @author Katybaby
 *
 */
public class AuthRole extends CreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String code; //角色代码(32位uuid)
	private String name; //角色名称
	private Boolean isSuper; //是否为超级管理员,0:否,1:是
	private Boolean isDefault; //是否为默认角色,默认为否
	private String description; //描述
    
	/**
	 *默认空构造函数
	 */
	public AuthRole() {
		super();
	}
	 
	/**
	 * @return code 角色代码(32位uuid)
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 角色代码(32位uuid)
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return name 角色名称
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 角色名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return isSuper 是否为超级管理员,0:否,1:是
	 */
	public Boolean getIsSuper(){
		return this.isSuper;
	}
	/**
	 * @param isSuper 是否为超级管理员,0:否,1:是
	 */
	public void setIsSuper(Boolean isSuper){
		this.isSuper = isSuper;
	}
	/**
	 * @return isDefault 是否为默认角色,默认为否
	 */
	public Boolean getIsDefault(){
		return this.isDefault;
	}
	/**
	 * @param isDefault 是否为默认角色,默认为否
	 */
	public void setIsDefault(Boolean isDefault){
		this.isDefault = isDefault;
	}
	/**
	 * @return description 描述
	 */
	public String getDescription(){
		return this.description;
	}
	/**
	 * @param description 描述
	 */
	public void setDescription(String description){
		this.description = description;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("code",getCode())
			.append("name",getName())
			.append("isSuper",getIsSuper())
			.append("isDefault",getIsDefault())
			.append("description",getDescription())
			.append("createDate",getCreateDate())
			.append("creator",getCreator())
			.append("lastModDate",getLastModDate())
			.append("lastModifier",getLastModifier())
			.append("status",getStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCode())
			.append(getName())
			.append(getIsSuper())
			.append(getIsDefault())
			.append(getDescription())
			.append(getCreateDate())
			.append(getCreator())
			.append(getLastModDate())
			.append(getLastModifier())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AuthRole == false) return false;
		if(this == obj) return true;
		AuthRole other = (AuthRole)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
