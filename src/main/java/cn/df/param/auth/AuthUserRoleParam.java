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

package cn.df.param.auth;

import cn.df.common.param.CreateBaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《用户角色》 查询参数实体
 * @author Katybaby
 *
 */
public class AuthUserRoleParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——用户代码
	*/
	public static final String F_Usercode="usercode";
	/**
	*字段常量——角色代码
	*/
	public static final String F_Rolecode="rolecode";
	
	private String usercode; //用户代码
	private String rolecode; //角色代码
    
	/**
	 *默认空构造函数
	 */
	public AuthUserRoleParam() {
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
	
}
