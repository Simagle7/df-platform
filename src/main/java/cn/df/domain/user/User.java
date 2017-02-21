/*
{*****************************************************************************
{  疾病预测 v1.0													
{  版权信息 (c) 2005-2017 katybaby. 保留所有权利.
{  创建人：  katybaby
{  审查人：
{  模块：用户基础表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2017-02-20  katybaby        新建	
{ 	                                                                     
{*****************************************************************************
*/

package cn.df.domain.user;

import cn.df.common.domain.CreateBaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《用户基础》 实体
 * @author katybaby
 *
 */
public class User extends CreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String code; //用户uid,为32位的uuid
	private String username; //用户名
	private String password; //密码
	private String salt; //加密盐
	private Integer age; //年龄
	private Boolean sex; //性别
	private String position; //职位
	private String workNum; //工号
    
	/**
	 *默认空构造函数
	 */
	public User() {
		super();
	}
	 
	/**
	 * @return code 用户uid,为32位的uuid
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 用户uid,为32位的uuid
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return username 用户名
	 */
	public String getUsername(){
		return this.username;
	}
	/**
	 * @param username 用户名
	 */
	public void setUsername(String username){
		this.username = username;
	}
	/**
	 * @return password 密码
	 */
	public String getPassword(){
		return this.password;
	}
	/**
	 * @param password 密码
	 */
	public void setPassword(String password){
		this.password = password;
	}
	/**
	 * @return salt 加密盐
	 */
	public String getSalt(){
		return this.salt;
	}
	/**
	 * @param salt 加密盐
	 */
	public void setSalt(String salt){
		this.salt = salt;
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
	 * @return sex 性别
	 */
	public Boolean getSex(){
		return this.sex;
	}
	/**
	 * @param sex 性别
	 */
	public void setSex(Boolean sex){
		this.sex = sex;
	}
	/**
	 * @return position 职位
	 */
	public String getPosition(){
		return this.position;
	}
	/**
	 * @param position 职位
	 */
	public void setPosition(String position){
		this.position = position;
	}
	/**
	 * @return workNum 工号
	 */
	public String getWorkNum(){
		return this.workNum;
	}
	/**
	 * @param workNum 工号
	 */
	public void setWorkNum(String workNum){
		this.workNum = workNum;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("code",getCode())
			.append("username",getUsername())
			.append("password",getPassword())
			.append("salt",getSalt())
			.append("age",getAge())
			.append("sex",getSex())
			.append("position",getPosition())
			.append("workNum",getWorkNum())
			.append("createDate",getCreateDate())
			.append("creator",getCreator())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCode())
			.append(getUsername())
			.append(getPassword())
			.append(getSalt())
			.append(getAge())
			.append(getSex())
			.append(getPosition())
			.append(getWorkNum())
			.append(getCreateDate())
			.append(getCreator())
			.append(getLastModifier())
			.append(getLastModDate())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof User == false) return false;
		if(this == obj) return true;
		User other = (User)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
