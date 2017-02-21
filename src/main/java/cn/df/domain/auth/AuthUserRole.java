/*
{*****************************************************************************
{  疾病预测 v1.0													
{  版权信息 (c) 2005-2017 Katybaby. 保留所有权利.
{  创建人：  Katybaby
{  审查人：
{  模块：用户角色表											
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
 * 《用户角色》 实体
 * @author Katybaby
 *
 */
public class AuthUserRole extends CreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String usercode; //用户代码
	private String rolecode; //角色代码
    
	/**
	 *默认空构造函数
	 */
	public AuthUserRole() {
		super();
	}
	 
	/**
	 * @return usercode 用户代码
	 */
	public String getUsercode(){
		return this.usercode;
	}
	/**
	 * @param usercode 用户代码
	 */
	public void setUsercode(String usercode){
		this.usercode = usercode;
	}
	/**
	 * @return rolecode 角色代码
	 */
	public String getRolecode(){
		return this.rolecode;
	}
	/**
	 * @param rolecode 角色代码
	 */
	public void setRolecode(String rolecode){
		this.rolecode = rolecode;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("usercode",getUsercode())
			.append("rolecode",getRolecode())
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
			.append(getUsercode())
			.append(getRolecode())
			.append(getCreator())
			.append(getCreateDate())
			.append(getLastModifier())
			.append(getLastModDate())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AuthUserRole == false) return false;
		if(this == obj) return true;
		AuthUserRole other = (AuthUserRole)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
