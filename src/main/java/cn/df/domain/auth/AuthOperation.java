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

package cn.df.domain.auth;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.df.common.domain.CreateBaseDomain;

import java.util.*;

/**
 * 《权限操作》 实体
 * @author Katybaby
 *
 */
public class AuthOperation extends CreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String code; //操作代码
	private String name; //操作名称
	private String moduleCode; //模块代码
	private String authCode; //权限代码
    
	/**
	 *默认空构造函数
	 */
	public AuthOperation() {
		super();
	}
	 
	/**
	 * @return code 操作代码
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 操作代码
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return name 操作名称
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 操作名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return moduleCode 模块代码
	 */
	public String getModuleCode(){
		return this.moduleCode;
	}
	/**
	 * @param moduleCode 模块代码
	 */
	public void setModuleCode(String moduleCode){
		this.moduleCode = moduleCode;
	}
	/**
	 * @return authCode 权限代码
	 */
	public String getAuthCode(){
		return this.authCode;
	}
	/**
	 * @param authCode 权限代码
	 */
	public void setAuthCode(String authCode){
		this.authCode = authCode;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("code",getCode())
			.append("name",getName())
			.append("moduleCode",getModuleCode())
			.append("authCode",getAuthCode())
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
			.append(getCode())
			.append(getName())
			.append(getModuleCode())
			.append(getAuthCode())
			.append(getCreator())
			.append(getCreateDate())
			.append(getLastModifier())
			.append(getLastModDate())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AuthOperation == false) return false;
		if(this == obj) return true;
		AuthOperation other = (AuthOperation)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
