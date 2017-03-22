/*
{*****************************************************************************
{  疾病预测 v1.0													
{  版权信息 (c) 2005-2017 Katybaby. 保留所有权利.
{  创建人：  Katybaby
{  审查人：
{  模块：体格检查表											
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

package cn.df.param.specimen;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.df.common.param.BaseParam;

import java.util.*;

/**
 * 《体格检查》 查询参数实体
 * @author Katybaby
 *
 */
public class PhysicalExaminationParam extends BaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——病人代码
	*/
	public static final String F_PatientCode="patientCode";
	/**
	*字段常量——是否面色苍白
	*/
	public static final String F_MSCB="MSCB";
	/**
	*字段常量——是否面色就白
	*/
	public static final String F_MSJB="MSJB";
	/**
	*字段常量——是否面色黯黑
	*/
	public static final String F_MSAH="MSAH";
	/**
	*字段常量——是否面色萎黄
	*/
	public static final String F_MSWH="MSWH";
	/**
	*字段常量——是否面红
	*/
	public static final String F_MH="MH";
	/**
	*字段常量——是否目赤
	*/
	public static final String F_MC="MC";
	/**
	*字段常量——是否眼周色暗
	*/
	public static final String F_YZSA="YZSA";
	/**
	*字段常量——是否眼睑浮肿
	*/
	public static final String F_YJFZ="YJFZ";
	/**
	*字段常量——是否唇龈暗红
	*/
	public static final String F_CYAH="CYAH";
	/**
	*字段常量——是否唇甲色淡
	*/
	public static final String F_CJSD="CJSD";
	/**
	*字段常量——是否腭黏膜黯
	*/
	public static final String F_ENMA="ENMA";
	/**
	*字段常量——是否少腹部压痛
	*/
	public static final String F_SFBYT="SFBYT";
	/**
	*字段常量——是否下肢水肿
	*/
	public static final String F_XZSZ="XZSZ";
	/**
	*字段常量——是否色调低微
	*/
	public static final String F_SDDW="SDDW";
	/**
	*字段常量——是否形体消瘦
	*/
	public static final String F_XTXS="XTXS";
	/**
	*字段常量——是否肺啰音
	*/
	public static final String F_FLY="FLY";
	/**
	*字段常量——是否心脏扩大
	*/
	public static final String F_XZKD="XZKD";
	/**
	*字段常量——是否心脏杂音
	*/
	public static final String F_XZZY="XZZY";
	
	private String patientCode; //病人代码
	private Boolean mSCB; //是否面色苍白
	private Boolean mSJB; //是否面色就白
	private Boolean mSAH; //是否面色黯黑
	private Boolean mSWH; //是否面色萎黄
	private Boolean mH; //是否面红
	private Boolean mC; //是否目赤
	private Boolean yZSA; //是否眼周色暗
	private Boolean yJFZ; //是否眼睑浮肿
	private Boolean cYAH; //是否唇龈暗红
	private Boolean cJSD; //是否唇甲色淡
	private Boolean eNMA; //是否腭黏膜黯
	private Boolean sFBYT; //是否少腹部压痛
	private Boolean xZSZ; //是否下肢水肿
	private Boolean sDDW; //是否色调低微
	private Boolean xTXS; //是否形体消瘦
	private Boolean fLY; //是否肺啰音
	private Boolean xZKD; //是否心脏扩大
	private Boolean xZZY; //是否心脏杂音
    
	/**
	 *默认空构造函数
	 */
	public PhysicalExaminationParam() {
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
	 * @return mSCB 是否面色苍白
	 */
	public Boolean getMSCB(){
		return this.mSCB;
	}
	/**
	 * @param mSCB 是否面色苍白
	 */
	public void setMSCB(Boolean mSCB){
		this.mSCB = mSCB;
	}
	/**
	 * @return mSJB 是否面色就白
	 */
	public Boolean getMSJB(){
		return this.mSJB;
	}
	/**
	 * @param mSJB 是否面色就白
	 */
	public void setMSJB(Boolean mSJB){
		this.mSJB = mSJB;
	}
	/**
	 * @return mSAH 是否面色黯黑
	 */
	public Boolean getMSAH(){
		return this.mSAH;
	}
	/**
	 * @param mSAH 是否面色黯黑
	 */
	public void setMSAH(Boolean mSAH){
		this.mSAH = mSAH;
	}
	/**
	 * @return mSWH 是否面色萎黄
	 */
	public Boolean getMSWH(){
		return this.mSWH;
	}
	/**
	 * @param mSWH 是否面色萎黄
	 */
	public void setMSWH(Boolean mSWH){
		this.mSWH = mSWH;
	}
	/**
	 * @return mH 是否面红
	 */
	public Boolean getMH(){
		return this.mH;
	}
	/**
	 * @param mH 是否面红
	 */
	public void setMH(Boolean mH){
		this.mH = mH;
	}
	/**
	 * @return mC 是否目赤
	 */
	public Boolean getMC(){
		return this.mC;
	}
	/**
	 * @param mC 是否目赤
	 */
	public void setMC(Boolean mC){
		this.mC = mC;
	}
	/**
	 * @return yZSA 是否眼周色暗
	 */
	public Boolean getYZSA(){
		return this.yZSA;
	}
	/**
	 * @param yZSA 是否眼周色暗
	 */
	public void setYZSA(Boolean yZSA){
		this.yZSA = yZSA;
	}
	/**
	 * @return yJFZ 是否眼睑浮肿
	 */
	public Boolean getYJFZ(){
		return this.yJFZ;
	}
	/**
	 * @param yJFZ 是否眼睑浮肿
	 */
	public void setYJFZ(Boolean yJFZ){
		this.yJFZ = yJFZ;
	}
	/**
	 * @return cYAH 是否唇龈暗红
	 */
	public Boolean getCYAH(){
		return this.cYAH;
	}
	/**
	 * @param cYAH 是否唇龈暗红
	 */
	public void setCYAH(Boolean cYAH){
		this.cYAH = cYAH;
	}
	/**
	 * @return cJSD 是否唇甲色淡
	 */
	public Boolean getCJSD(){
		return this.cJSD;
	}
	/**
	 * @param cJSD 是否唇甲色淡
	 */
	public void setCJSD(Boolean cJSD){
		this.cJSD = cJSD;
	}
	/**
	 * @return eNMA 是否腭黏膜黯
	 */
	public Boolean getENMA(){
		return this.eNMA;
	}
	/**
	 * @param eNMA 是否腭黏膜黯
	 */
	public void setENMA(Boolean eNMA){
		this.eNMA = eNMA;
	}
	/**
	 * @return sFBYT 是否少腹部压痛
	 */
	public Boolean getSFBYT(){
		return this.sFBYT;
	}
	/**
	 * @param sFBYT 是否少腹部压痛
	 */
	public void setSFBYT(Boolean sFBYT){
		this.sFBYT = sFBYT;
	}
	/**
	 * @return xZSZ 是否下肢水肿
	 */
	public Boolean getXZSZ(){
		return this.xZSZ;
	}
	/**
	 * @param xZSZ 是否下肢水肿
	 */
	public void setXZSZ(Boolean xZSZ){
		this.xZSZ = xZSZ;
	}
	/**
	 * @return sDDW 是否色调低微
	 */
	public Boolean getSDDW(){
		return this.sDDW;
	}
	/**
	 * @param sDDW 是否色调低微
	 */
	public void setSDDW(Boolean sDDW){
		this.sDDW = sDDW;
	}
	/**
	 * @return xTXS 是否形体消瘦
	 */
	public Boolean getXTXS(){
		return this.xTXS;
	}
	/**
	 * @param xTXS 是否形体消瘦
	 */
	public void setXTXS(Boolean xTXS){
		this.xTXS = xTXS;
	}
	/**
	 * @return fLY 是否肺啰音
	 */
	public Boolean getFLY(){
		return this.fLY;
	}
	/**
	 * @param fLY 是否肺啰音
	 */
	public void setFLY(Boolean fLY){
		this.fLY = fLY;
	}
	/**
	 * @return xZKD 是否心脏扩大
	 */
	public Boolean getXZKD(){
		return this.xZKD;
	}
	/**
	 * @param xZKD 是否心脏扩大
	 */
	public void setXZKD(Boolean xZKD){
		this.xZKD = xZKD;
	}
	/**
	 * @return xZZY 是否心脏杂音
	 */
	public Boolean getXZZY(){
		return this.xZZY;
	}
	/**
	 * @param xZZY 是否心脏杂音
	 */
	public void setXZZY(Boolean xZZY){
		this.xZZY = xZZY;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("patientCode",getPatientCode())
			.append("MSCB",getMSCB())
			.append("MSJB",getMSJB())
			.append("MSAH",getMSAH())
			.append("MSWH",getMSWH())
			.append("MH",getMH())
			.append("MC",getMC())
			.append("YZSA",getYZSA())
			.append("YJFZ",getYJFZ())
			.append("CYAH",getCYAH())
			.append("CJSD",getCJSD())
			.append("ENMA",getENMA())
			.append("SFBYT",getSFBYT())
			.append("XZSZ",getXZSZ())
			.append("SDDW",getSDDW())
			.append("XTXS",getXTXS())
			.append("FLY",getFLY())
			.append("XZKD",getXZKD())
			.append("XZZY",getXZZY())
			.toString();
	}
	
}
