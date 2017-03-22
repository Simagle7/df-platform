/*
{*****************************************************************************
{  疾病预测 v1.0													
{  版权信息 (c) 2005-2017 Katybaby. 保留所有权利.
{  创建人：  Katybaby
{  审查人：
{  模块：专科检查表											
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
 * 《专科检查》 实体
 * @author Katybaby
 *
 */
public class SpecializedExamination extends BaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String patientCode; //病人代码
	private Boolean sDB; //是否舌淡白
	private Boolean sH; //是否舌红
	private Boolean sFH; //是否舌锋红
	private Boolean sAH; //是否舌暗红
	private Boolean sAZ; //是否舌暗紫
	private Boolean sTFD; //是否舌体肥大
	private Boolean sTSX; //是否舌体瘦小
	private Boolean cHS; //是否齿痕舌
	private Boolean hT; //是否厚苔
	private Boolean nT; //是否腻苔
	private Boolean fT; //是否腐苔
	private Boolean sT; //是否少苔
	private Boolean cM; //是否沉脉
	private Boolean sM; //是否数脉
	private Boolean hM; //是否缓脉
	private Boolean jDM; //是否结代脉
	private Boolean cHIM; //是否迟脉
	private Boolean xIM; //是否细脉
	private Boolean xM; //是否弦脉
	private Boolean jM; //是否紧脉
	private Boolean lM; //是否漓脉
	private Boolean hUAM; //是否滑脉
	private Boolean rM; //是否弱脉
	private Boolean hBT; //是否花剥苔
	private Boolean wT; //是否无苔
	private Boolean hNT; //是否厚腻苔
	private Boolean tH; //是否滑苔
	private Boolean tSH; //是否苔色滑
	private Boolean tSHE; //是否苔色黑
	private Boolean sYBY; //是否舌瘀癍瘀点
	private Boolean lMDZ; //是否络脉淡紫
	private Boolean lMQZ; //是否络脉青紫
	private Boolean lMZH; //是否络脉紫黑
	private Boolean lMZHO; //是否络脉紫红
	private Boolean lMNZ; //是否络脉怒张
	private Boolean lMXX; //是否络脉细小
    
	/**
	 *默认空构造函数
	 */
	public SpecializedExamination() {
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
	 * @return sDB 是否舌淡白
	 */
	public Boolean getSDB(){
		return this.sDB;
	}
	/**
	 * @param sDB 是否舌淡白
	 */
	public void setSDB(Boolean sDB){
		this.sDB = sDB;
	}
	/**
	 * @return sH 是否舌红
	 */
	public Boolean getSH(){
		return this.sH;
	}
	/**
	 * @param sH 是否舌红
	 */
	public void setSH(Boolean sH){
		this.sH = sH;
	}
	/**
	 * @return sFH 是否舌锋红
	 */
	public Boolean getSFH(){
		return this.sFH;
	}
	/**
	 * @param sFH 是否舌锋红
	 */
	public void setSFH(Boolean sFH){
		this.sFH = sFH;
	}
	/**
	 * @return sAH 是否舌暗红
	 */
	public Boolean getSAH(){
		return this.sAH;
	}
	/**
	 * @param sAH 是否舌暗红
	 */
	public void setSAH(Boolean sAH){
		this.sAH = sAH;
	}
	/**
	 * @return sAZ 是否舌暗紫
	 */
	public Boolean getSAZ(){
		return this.sAZ;
	}
	/**
	 * @param sAZ 是否舌暗紫
	 */
	public void setSAZ(Boolean sAZ){
		this.sAZ = sAZ;
	}
	/**
	 * @return sTFD 是否舌体肥大
	 */
	public Boolean getSTFD(){
		return this.sTFD;
	}
	/**
	 * @param sTFD 是否舌体肥大
	 */
	public void setSTFD(Boolean sTFD){
		this.sTFD = sTFD;
	}
	/**
	 * @return sTSX 是否舌体瘦小
	 */
	public Boolean getSTSX(){
		return this.sTSX;
	}
	/**
	 * @param sTSX 是否舌体瘦小
	 */
	public void setSTSX(Boolean sTSX){
		this.sTSX = sTSX;
	}
	/**
	 * @return cHS 是否齿痕舌
	 */
	public Boolean getCHS(){
		return this.cHS;
	}
	/**
	 * @param cHS 是否齿痕舌
	 */
	public void setCHS(Boolean cHS){
		this.cHS = cHS;
	}
	/**
	 * @return hT 是否厚苔
	 */
	public Boolean getHT(){
		return this.hT;
	}
	/**
	 * @param hT 是否厚苔
	 */
	public void setHT(Boolean hT){
		this.hT = hT;
	}
	/**
	 * @return nT 是否腻苔
	 */
	public Boolean getNT(){
		return this.nT;
	}
	/**
	 * @param nT 是否腻苔
	 */
	public void setNT(Boolean nT){
		this.nT = nT;
	}
	/**
	 * @return fT 是否腐苔
	 */
	public Boolean getFT(){
		return this.fT;
	}
	/**
	 * @param fT 是否腐苔
	 */
	public void setFT(Boolean fT){
		this.fT = fT;
	}
	/**
	 * @return sT 是否少苔
	 */
	public Boolean getST(){
		return this.sT;
	}
	/**
	 * @param sT 是否少苔
	 */
	public void setST(Boolean sT){
		this.sT = sT;
	}
	/**
	 * @return cM 是否沉脉
	 */
	public Boolean getCM(){
		return this.cM;
	}
	/**
	 * @param cM 是否沉脉
	 */
	public void setCM(Boolean cM){
		this.cM = cM;
	}
	/**
	 * @return sM 是否数脉
	 */
	public Boolean getSM(){
		return this.sM;
	}
	/**
	 * @param sM 是否数脉
	 */
	public void setSM(Boolean sM){
		this.sM = sM;
	}
	/**
	 * @return hM 是否缓脉
	 */
	public Boolean getHM(){
		return this.hM;
	}
	/**
	 * @param hM 是否缓脉
	 */
	public void setHM(Boolean hM){
		this.hM = hM;
	}
	/**
	 * @return jDM 是否结代脉
	 */
	public Boolean getJDM(){
		return this.jDM;
	}
	/**
	 * @param jDM 是否结代脉
	 */
	public void setJDM(Boolean jDM){
		this.jDM = jDM;
	}
	/**
	 * @return cHIM 是否迟脉
	 */
	public Boolean getCHIM(){
		return this.cHIM;
	}
	/**
	 * @param cHIM 是否迟脉
	 */
	public void setCHIM(Boolean cHIM){
		this.cHIM = cHIM;
	}
	/**
	 * @return xIM 是否细脉
	 */
	public Boolean getXIM(){
		return this.xIM;
	}
	/**
	 * @param xIM 是否细脉
	 */
	public void setXIM(Boolean xIM){
		this.xIM = xIM;
	}
	/**
	 * @return xM 是否弦脉
	 */
	public Boolean getXM(){
		return this.xM;
	}
	/**
	 * @param xM 是否弦脉
	 */
	public void setXM(Boolean xM){
		this.xM = xM;
	}
	/**
	 * @return jM 是否紧脉
	 */
	public Boolean getJM(){
		return this.jM;
	}
	/**
	 * @param jM 是否紧脉
	 */
	public void setJM(Boolean jM){
		this.jM = jM;
	}
	/**
	 * @return lM 是否漓脉
	 */
	public Boolean getLM(){
		return this.lM;
	}
	/**
	 * @param lM 是否漓脉
	 */
	public void setLM(Boolean lM){
		this.lM = lM;
	}
	/**
	 * @return hUAM 是否滑脉
	 */
	public Boolean getHUAM(){
		return this.hUAM;
	}
	/**
	 * @param hUAM 是否滑脉
	 */
	public void setHUAM(Boolean hUAM){
		this.hUAM = hUAM;
	}
	/**
	 * @return rM 是否弱脉
	 */
	public Boolean getRM(){
		return this.rM;
	}
	/**
	 * @param rM 是否弱脉
	 */
	public void setRM(Boolean rM){
		this.rM = rM;
	}
	/**
	 * @return hBT 是否花剥苔
	 */
	public Boolean getHBT(){
		return this.hBT;
	}
	/**
	 * @param hBT 是否花剥苔
	 */
	public void setHBT(Boolean hBT){
		this.hBT = hBT;
	}
	/**
	 * @return wT 是否无苔
	 */
	public Boolean getWT(){
		return this.wT;
	}
	/**
	 * @param wT 是否无苔
	 */
	public void setWT(Boolean wT){
		this.wT = wT;
	}
	/**
	 * @return hNT 是否厚腻苔
	 */
	public Boolean getHNT(){
		return this.hNT;
	}
	/**
	 * @param hNT 是否厚腻苔
	 */
	public void setHNT(Boolean hNT){
		this.hNT = hNT;
	}
	/**
	 * @return tH 是否滑苔
	 */
	public Boolean getTH(){
		return this.tH;
	}
	/**
	 * @param tH 是否滑苔
	 */
	public void setTH(Boolean tH){
		this.tH = tH;
	}
	/**
	 * @return tSH 是否苔色滑
	 */
	public Boolean getTSH(){
		return this.tSH;
	}
	/**
	 * @param tSH 是否苔色滑
	 */
	public void setTSH(Boolean tSH){
		this.tSH = tSH;
	}
	/**
	 * @return tSHE 是否苔色黑
	 */
	public Boolean getTSHE(){
		return this.tSHE;
	}
	/**
	 * @param tSHE 是否苔色黑
	 */
	public void setTSHE(Boolean tSHE){
		this.tSHE = tSHE;
	}
	/**
	 * @return sYBY 是否舌瘀癍瘀点
	 */
	public Boolean getSYBY(){
		return this.sYBY;
	}
	/**
	 * @param sYBY 是否舌瘀癍瘀点
	 */
	public void setSYBY(Boolean sYBY){
		this.sYBY = sYBY;
	}
	/**
	 * @return lMDZ 是否络脉淡紫
	 */
	public Boolean getLMDZ(){
		return this.lMDZ;
	}
	/**
	 * @param lMDZ 是否络脉淡紫
	 */
	public void setLMDZ(Boolean lMDZ){
		this.lMDZ = lMDZ;
	}
	/**
	 * @return lMQZ 是否络脉青紫
	 */
	public Boolean getLMQZ(){
		return this.lMQZ;
	}
	/**
	 * @param lMQZ 是否络脉青紫
	 */
	public void setLMQZ(Boolean lMQZ){
		this.lMQZ = lMQZ;
	}
	/**
	 * @return lMZH 是否络脉紫黑
	 */
	public Boolean getLMZH(){
		return this.lMZH;
	}
	/**
	 * @param lMZH 是否络脉紫黑
	 */
	public void setLMZH(Boolean lMZH){
		this.lMZH = lMZH;
	}
	/**
	 * @return lMZHO 是否络脉紫红
	 */
	public Boolean getLMZHO(){
		return this.lMZHO;
	}
	/**
	 * @param lMZHO 是否络脉紫红
	 */
	public void setLMZHO(Boolean lMZHO){
		this.lMZHO = lMZHO;
	}
	/**
	 * @return lMNZ 是否络脉怒张
	 */
	public Boolean getLMNZ(){
		return this.lMNZ;
	}
	/**
	 * @param lMNZ 是否络脉怒张
	 */
	public void setLMNZ(Boolean lMNZ){
		this.lMNZ = lMNZ;
	}
	/**
	 * @return lMXX 是否络脉细小
	 */
	public Boolean getLMXX(){
		return this.lMXX;
	}
	/**
	 * @param lMXX 是否络脉细小
	 */
	public void setLMXX(Boolean lMXX){
		this.lMXX = lMXX;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("patientCode",getPatientCode())
			.append("SDB",getSDB())
			.append("SH",getSH())
			.append("SFH",getSFH())
			.append("SAH",getSAH())
			.append("SAZ",getSAZ())
			.append("STFD",getSTFD())
			.append("STSX",getSTSX())
			.append("CHS",getCHS())
			.append("HT",getHT())
			.append("NT",getNT())
			.append("FT",getFT())
			.append("ST",getST())
			.append("CM",getCM())
			.append("SM",getSM())
			.append("HM",getHM())
			.append("JDM",getJDM())
			.append("CHIM",getCHIM())
			.append("XIM",getXIM())
			.append("XM",getXM())
			.append("JM",getJM())
			.append("LM",getLM())
			.append("HUAM",getHUAM())
			.append("RM",getRM())
			.append("HBT",getHBT())
			.append("WT",getWT())
			.append("HNT",getHNT())
			.append("TH",getTH())
			.append("TSH",getTSH())
			.append("TSHE",getTSHE())
			.append("SYBY",getSYBY())
			.append("LMDZ",getLMDZ())
			.append("LMQZ",getLMQZ())
			.append("LMZH",getLMZH())
			.append("LMZHO",getLMZHO())
			.append("LMNZ",getLMNZ())
			.append("LMXX",getLMXX())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getPatientCode())
			.append(getSDB())
			.append(getSH())
			.append(getSFH())
			.append(getSAH())
			.append(getSAZ())
			.append(getSTFD())
			.append(getSTSX())
			.append(getCHS())
			.append(getHT())
			.append(getNT())
			.append(getFT())
			.append(getST())
			.append(getCM())
			.append(getSM())
			.append(getHM())
			.append(getJDM())
			.append(getCHIM())
			.append(getXIM())
			.append(getXM())
			.append(getJM())
			.append(getLM())
			.append(getHUAM())
			.append(getRM())
			.append(getHBT())
			.append(getWT())
			.append(getHNT())
			.append(getTH())
			.append(getTSH())
			.append(getTSHE())
			.append(getSYBY())
			.append(getLMDZ())
			.append(getLMQZ())
			.append(getLMZH())
			.append(getLMZHO())
			.append(getLMNZ())
			.append(getLMXX())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SpecializedExamination == false) return false;
		if(this == obj) return true;
		SpecializedExamination other = (SpecializedExamination)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
