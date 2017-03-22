/*
{*****************************************************************************
{  疾病预测 v1.0													
{  版权信息 (c) 2005-2017 Katybaby. 保留所有权利.
{  创建人：  Katybaby
{  审查人：
{  模块：彩超表											
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

package cn.df.domain.specimen;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.df.common.domain.BaseDomain;

import java.util.*;

/**
 * 《彩超》 实体
 * @author Katybaby
 *
 */
public class ColorUltrasound extends BaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String patientCode; //病人代码
	private Double zDMGB; //主动脉根部
	private Double zXF; //左心房
	private Double yXF; //右心房
	private Double sJG; //室间隔
	private Double zXS; //左心室
	private Double yXS; //右心室
	private Double zXSHB; //左心室后壁
	private Double fDM; //脉动脉
	private Double eF; //EF
	private Double fS; //FS
    
	/**
	 *默认空构造函数
	 */
	public ColorUltrasound() {
		super();
	}
	 
	/**
	 * @return patientCode 病人代码
	 */
	public String getPatientCode(){
		return this.patientCode;
	}
	/**
	 * @param patientCode 病人代码
	 */
	public void setPatientCode(String patientCode){
		this.patientCode = patientCode;
	}
	/**
	 * @return zDMGB 主动脉根部
	 */
	public Double getZDMGB(){
		return this.zDMGB;
	}
	/**
	 * @param zDMGB 主动脉根部
	 */
	public void setZDMGB(Double zDMGB){
		this.zDMGB = zDMGB;
	}
	/**
	 * @return zXF 左心房
	 */
	public Double getZXF(){
		return this.zXF;
	}
	/**
	 * @param zXF 左心房
	 */
	public void setZXF(Double zXF){
		this.zXF = zXF;
	}
	/**
	 * @return yXF 右心房
	 */
	public Double getYXF(){
		return this.yXF;
	}
	/**
	 * @param yXF 右心房
	 */
	public void setYXF(Double yXF){
		this.yXF = yXF;
	}
	/**
	 * @return sJG 室间隔
	 */
	public Double getSJG(){
		return this.sJG;
	}
	/**
	 * @param sJG 室间隔
	 */
	public void setSJG(Double sJG){
		this.sJG = sJG;
	}
	/**
	 * @return zXS 左心室
	 */
	public Double getZXS(){
		return this.zXS;
	}
	/**
	 * @param zXS 左心室
	 */
	public void setZXS(Double zXS){
		this.zXS = zXS;
	}
	/**
	 * @return yXS 右心室
	 */
	public Double getYXS(){
		return this.yXS;
	}
	/**
	 * @param yXS 右心室
	 */
	public void setYXS(Double yXS){
		this.yXS = yXS;
	}
	/**
	 * @return zXSHB 左心室后壁
	 */
	public Double getZXSHB(){
		return this.zXSHB;
	}
	/**
	 * @param zXSHB 左心室后壁
	 */
	public void setZXSHB(Double zXSHB){
		this.zXSHB = zXSHB;
	}
	/**
	 * @return fDM 脉动脉
	 */
	public Double getFDM(){
		return this.fDM;
	}
	/**
	 * @param fDM 脉动脉
	 */
	public void setFDM(Double fDM){
		this.fDM = fDM;
	}
	/**
	 * @return eF EF
	 */
	public Double getEF(){
		return this.eF;
	}
	/**
	 * @param eF EF
	 */
	public void setEF(Double eF){
		this.eF = eF;
	}
	/**
	 * @return fS FS
	 */
	public Double getFS(){
		return this.fS;
	}
	/**
	 * @param fS FS
	 */
	public void setFS(Double fS){
		this.fS = fS;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("patientCode",getPatientCode())
			.append("ZDMGB",getZDMGB())
			.append("ZXF",getZXF())
			.append("YXF",getYXF())
			.append("SJG",getSJG())
			.append("ZXS",getZXS())
			.append("YXS",getYXS())
			.append("ZXSHB",getZXSHB())
			.append("FDM",getFDM())
			.append("EF",getEF())
			.append("FS",getFS())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getPatientCode())
			.append(getZDMGB())
			.append(getZXF())
			.append(getYXF())
			.append(getSJG())
			.append(getZXS())
			.append(getYXS())
			.append(getZXSHB())
			.append(getFDM())
			.append(getEF())
			.append(getFS())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ColorUltrasound == false) return false;
		if(this == obj) return true;
		ColorUltrasound other = (ColorUltrasound)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
