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
{  2017-03-27  Katybaby        新建
{
{*****************************************************************************
*/

package cn.df.param.specimen;

import cn.df.common.param.BaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《病人》 查询参数实体
 * @author Katybaby
 *
 */
public class PatientParam extends BaseParam<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 *字段常量——病人代码，主键，为32位uuid
	 */
	public static final String F_Code="code";
	/**
	 *字段常量——住址
	 */
	public static final String F_Address="address";
	/**
	 *字段常量——姓名
	 */
	public static final String F_Name="name";
	/**
	 *字段常量——职业
	 */
	public static final String F_Career="career";
	/**
	 *字段常量——性别，0：男，1：女
	 */
	public static final String F_Gender="gender";
	/**
	 *字段常量——年龄
	 */
	public static final String F_Age="age";
	/**
	 *字段常量——患病概率
	 */
	public static final String F_Probability="probability";
	/**
	 *字段常量——是否患病，0：否，1：是
	 */
	public static final String F_IsSicken="isSicken";

	private String code; //病人代码，主键，为32位uuid
	private String address; //住址
	private String name; //姓名
	private String career; //职业
	private Integer gender; //性别，0：男，1：女
	private Integer age; //年龄
	private Double probability; //患病概率
	private Integer isSicken; //是否患病，0：否，1：是

	/**
	 *默认空构造函数
	 */
	public PatientParam() {
		super();
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
	 * @return address 住址
	 */
	public String getAddress(){
		return this.address;
	}
	/**
	 * @param address 住址
	 */
	public void setAddress(String address){
		this.address = address;
	}
	/**
	 * @return name 姓名
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 姓名
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return career 职业
	 */
	public String getCareer(){
		return this.career;
	}
	/**
	 * @param career 职业
	 */
	public void setCareer(String career){
		this.career = career;
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
	 * @return probability 患病概率
	 */
	public Double getProbability(){
		return this.probability;
	}
	/**
	 * @param probability 患病概率
	 */
	public void setProbability(Double probability){
		this.probability = probability;
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
				.append("code",getCode())
				.append("address",getAddress())
				.append("name",getName())
				.append("career",getCareer())
				.append("gender",getGender())
				.append("age",getAge())
				.append("probability",getProbability())
				.append("isSicken",getIsSicken())
				.toString();
	}

}