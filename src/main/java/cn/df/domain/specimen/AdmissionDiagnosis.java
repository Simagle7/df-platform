/*
{*****************************************************************************
{  疾病预测 v1.0													
{  版权信息 (c) 2005-2017 Katybaby. 保留所有权利.
{  创建人：  Katybaby
{  审查人：
{  模块：入院症见表											
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

import cn.df.common.domain.BaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《入院症见》 实体
 * @author Katybaby
 *
 */
public class AdmissionDiagnosis extends BaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String patientCode; //病人代码
	private Boolean xT; //是否胸痛
	private Boolean xM; //是否胸闷
	private Boolean xJ; //是否心悸
	private Boolean qD; //是否气短
	private Boolean qC; //是否气促
	private Boolean kS; //是否咳嗽
	private Boolean wHZL; //是否畏寒肢冷
	private Boolean pJFL; //是否疲倦乏力
	private Boolean zH; //是否自汗
	private Boolean dH; //是否盗汗
	private Boolean wXFR; //是否五心烦热
	private Boolean lMGS; //是否两目干湿
	private Boolean tY; //是否头晕
	private Boolean jW; //是否健忘
	private Boolean tH; //是否头昏
	private Boolean sM; //是否失眠
	private Boolean jZYN; //是否急躁易怒
	private Boolean lZ; //是否肋胀
	private Boolean tX; //是否太息
	private Boolean yY; //是否抑郁
	private Boolean sYBZ; //是否食欲不振
	private Boolean fZ; //是否腹胀
	private Boolean aP; //是否胺痞
	private Boolean aQ; //是否嗳气
	private Boolean eXOT; //是否恶心呕吐
	private Boolean bT; //是否便溏
	private Boolean bM; //是否便秘
	private Boolean yQSR; //是否腰膝酸软
	private Boolean yNPD; //是否夜尿频多
	private Boolean zTMM; //是否肢体麻木
	private Boolean zTPT; //是否肢体偏瘫
	private Boolean pXYX; //是否皮下淤血
	private Boolean pFCC; //是否皮肤粗糙
	private Boolean xTFP; //是否形体肥胖
	private Boolean bAIT; //是否白痰
	private Boolean hT; //是否黄痰
	private Boolean tZDX; //是否痰中带血
	private Boolean pMT; //是否泡沫痰
	private Boolean yBYW; //是否咽部异物
	private Boolean kBDY; //是否渴不多饮
	private Boolean kD; //是否口淡
	private Boolean kK; //是否口苦
	private Boolean kT; //是否口甜
	private Boolean kX; //是否口咸
	private Boolean kNN; //是否口黏腻
	private Boolean wGXW; //是否五更泻湾
	private Boolean pBWL; //是否排便无力
	private Boolean xBDH; //是否小便短黄
	private Boolean xBQC; //是否小便清长
	private Boolean yLBJ; //是否余沥不尽
	private Boolean wFYL; //是否脘腹腰冷
	private Boolean tZCZ; //是否肢体沉重
    
	/**
	 *默认空构造函数
	 */
	public AdmissionDiagnosis() {
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
	 * @return xT 是否胸痛
	 */
	public Boolean getXT(){
		return this.xT;
	}
	/**
	 * @param xT 是否胸痛
	 */
	public void setXT(Boolean xT){
		this.xT = xT;
	}
	/**
	 * @return xM 是否胸闷
	 */
	public Boolean getXM(){
		return this.xM;
	}
	/**
	 * @param xM 是否胸闷
	 */
	public void setXM(Boolean xM){
		this.xM = xM;
	}
	/**
	 * @return xJ 是否心悸
	 */
	public Boolean getXJ(){
		return this.xJ;
	}
	/**
	 * @param xJ 是否心悸
	 */
	public void setXJ(Boolean xJ){
		this.xJ = xJ;
	}
	/**
	 * @return qD 是否气短
	 */
	public Boolean getQD(){
		return this.qD;
	}
	/**
	 * @param qD 是否气短
	 */
	public void setQD(Boolean qD){
		this.qD = qD;
	}
	/**
	 * @return qC 是否气促
	 */
	public Boolean getQC(){
		return this.qC;
	}
	/**
	 * @param qC 是否气促
	 */
	public void setQC(Boolean qC){
		this.qC = qC;
	}
	/**
	 * @return kS 是否咳嗽
	 */
	public Boolean getKS(){
		return this.kS;
	}
	/**
	 * @param kS 是否咳嗽
	 */
	public void setKS(Boolean kS){
		this.kS = kS;
	}
	/**
	 * @return wHZL 是否畏寒肢冷
	 */
	public Boolean getWHZL(){
		return this.wHZL;
	}
	/**
	 * @param wHZL 是否畏寒肢冷
	 */
	public void setWHZL(Boolean wHZL){
		this.wHZL = wHZL;
	}
	/**
	 * @return pJFL 是否疲倦乏力
	 */
	public Boolean getPJFL(){
		return this.pJFL;
	}
	/**
	 * @param pJFL 是否疲倦乏力
	 */
	public void setPJFL(Boolean pJFL){
		this.pJFL = pJFL;
	}
	/**
	 * @return zH 是否自汗
	 */
	public Boolean getZH(){
		return this.zH;
	}
	/**
	 * @param zH 是否自汗
	 */
	public void setZH(Boolean zH){
		this.zH = zH;
	}
	/**
	 * @return dH 是否盗汗
	 */
	public Boolean getDH(){
		return this.dH;
	}
	/**
	 * @param dH 是否盗汗
	 */
	public void setDH(Boolean dH){
		this.dH = dH;
	}
	/**
	 * @return wXFR 是否五心烦热
	 */
	public Boolean getWXFR(){
		return this.wXFR;
	}
	/**
	 * @param wXFR 是否五心烦热
	 */
	public void setWXFR(Boolean wXFR){
		this.wXFR = wXFR;
	}
	/**
	 * @return lMGS 是否两目干湿
	 */
	public Boolean getLMGS(){
		return this.lMGS;
	}
	/**
	 * @param lMGS 是否两目干湿
	 */
	public void setLMGS(Boolean lMGS){
		this.lMGS = lMGS;
	}
	/**
	 * @return tY 是否头晕
	 */
	public Boolean getTY(){
		return this.tY;
	}
	/**
	 * @param tY 是否头晕
	 */
	public void setTY(Boolean tY){
		this.tY = tY;
	}
	/**
	 * @return jW 是否健忘
	 */
	public Boolean getJW(){
		return this.jW;
	}
	/**
	 * @param jW 是否健忘
	 */
	public void setJW(Boolean jW){
		this.jW = jW;
	}
	/**
	 * @return tH 是否头昏
	 */
	public Boolean getTH(){
		return this.tH;
	}
	/**
	 * @param tH 是否头昏
	 */
	public void setTH(Boolean tH){
		this.tH = tH;
	}
	/**
	 * @return sM 是否失眠
	 */
	public Boolean getSM(){
		return this.sM;
	}
	/**
	 * @param sM 是否失眠
	 */
	public void setSM(Boolean sM){
		this.sM = sM;
	}
	/**
	 * @return jZYN 是否急躁易怒
	 */
	public Boolean getJZYN(){
		return this.jZYN;
	}
	/**
	 * @param jZYN 是否急躁易怒
	 */
	public void setJZYN(Boolean jZYN){
		this.jZYN = jZYN;
	}
	/**
	 * @return lZ 是否肋胀
	 */
	public Boolean getLZ(){
		return this.lZ;
	}
	/**
	 * @param lZ 是否肋胀
	 */
	public void setLZ(Boolean lZ){
		this.lZ = lZ;
	}
	/**
	 * @return tX 是否太息
	 */
	public Boolean getTX(){
		return this.tX;
	}
	/**
	 * @param tX 是否太息
	 */
	public void setTX(Boolean tX){
		this.tX = tX;
	}
	/**
	 * @return yY 是否抑郁
	 */
	public Boolean getYY(){
		return this.yY;
	}
	/**
	 * @param yY 是否抑郁
	 */
	public void setYY(Boolean yY){
		this.yY = yY;
	}
	/**
	 * @return sYBZ 是否食欲不振
	 */
	public Boolean getSYBZ(){
		return this.sYBZ;
	}
	/**
	 * @param sYBZ 是否食欲不振
	 */
	public void setSYBZ(Boolean sYBZ){
		this.sYBZ = sYBZ;
	}
	/**
	 * @return fZ 是否腹胀
	 */
	public Boolean getFZ(){
		return this.fZ;
	}
	/**
	 * @param fZ 是否腹胀
	 */
	public void setFZ(Boolean fZ){
		this.fZ = fZ;
	}
	/**
	 * @return aP 是否胺痞
	 */
	public Boolean getAP(){
		return this.aP;
	}
	/**
	 * @param aP 是否胺痞
	 */
	public void setAP(Boolean aP){
		this.aP = aP;
	}
	/**
	 * @return aQ 是否嗳气
	 */
	public Boolean getAQ(){
		return this.aQ;
	}
	/**
	 * @param aQ 是否嗳气
	 */
	public void setAQ(Boolean aQ){
		this.aQ = aQ;
	}
	/**
	 * @return eXOT 是否恶心呕吐
	 */
	public Boolean getEXOT(){
		return this.eXOT;
	}
	/**
	 * @param eXOT 是否恶心呕吐
	 */
	public void setEXOT(Boolean eXOT){
		this.eXOT = eXOT;
	}
	/**
	 * @return bT 是否便溏
	 */
	public Boolean getBT(){
		return this.bT;
	}
	/**
	 * @param bT 是否便溏
	 */
	public void setBT(Boolean bT){
		this.bT = bT;
	}
	/**
	 * @return bM 是否便秘
	 */
	public Boolean getBM(){
		return this.bM;
	}
	/**
	 * @param bM 是否便秘
	 */
	public void setBM(Boolean bM){
		this.bM = bM;
	}
	/**
	 * @return yQSR 是否腰膝酸软
	 */
	public Boolean getYQSR(){
		return this.yQSR;
	}
	/**
	 * @param yQSR 是否腰膝酸软
	 */
	public void setYQSR(Boolean yQSR){
		this.yQSR = yQSR;
	}
	/**
	 * @return yNPD 是否夜尿频多
	 */
	public Boolean getYNPD(){
		return this.yNPD;
	}
	/**
	 * @param yNPD 是否夜尿频多
	 */
	public void setYNPD(Boolean yNPD){
		this.yNPD = yNPD;
	}
	/**
	 * @return zTMM 是否肢体麻木
	 */
	public Boolean getZTMM(){
		return this.zTMM;
	}
	/**
	 * @param zTMM 是否肢体麻木
	 */
	public void setZTMM(Boolean zTMM){
		this.zTMM = zTMM;
	}
	/**
	 * @return zTPT 是否肢体偏瘫
	 */
	public Boolean getZTPT(){
		return this.zTPT;
	}
	/**
	 * @param zTPT 是否肢体偏瘫
	 */
	public void setZTPT(Boolean zTPT){
		this.zTPT = zTPT;
	}
	/**
	 * @return pXYX 是否皮下淤血
	 */
	public Boolean getPXYX(){
		return this.pXYX;
	}
	/**
	 * @param pXYX 是否皮下淤血
	 */
	public void setPXYX(Boolean pXYX){
		this.pXYX = pXYX;
	}
	/**
	 * @return pFCC 是否皮肤粗糙
	 */
	public Boolean getPFCC(){
		return this.pFCC;
	}
	/**
	 * @param pFCC 是否皮肤粗糙
	 */
	public void setPFCC(Boolean pFCC){
		this.pFCC = pFCC;
	}
	/**
	 * @return xTFP 是否形体肥胖
	 */
	public Boolean getXTFP(){
		return this.xTFP;
	}
	/**
	 * @param xTFP 是否形体肥胖
	 */
	public void setXTFP(Boolean xTFP){
		this.xTFP = xTFP;
	}
	/**
	 * @return bAIT 是否白痰
	 */
	public Boolean getBAIT(){
		return this.bAIT;
	}
	/**
	 * @param bAIT 是否白痰
	 */
	public void setBAIT(Boolean bAIT){
		this.bAIT = bAIT;
	}
	/**
	 * @return hT 是否黄痰
	 */
	public Boolean getHT(){
		return this.hT;
	}
	/**
	 * @param hT 是否黄痰
	 */
	public void setHT(Boolean hT){
		this.hT = hT;
	}
	/**
	 * @return tZDX 是否痰中带血
	 */
	public Boolean getTZDX(){
		return this.tZDX;
	}
	/**
	 * @param tZDX 是否痰中带血
	 */
	public void setTZDX(Boolean tZDX){
		this.tZDX = tZDX;
	}
	/**
	 * @return pMT 是否泡沫痰
	 */
	public Boolean getPMT(){
		return this.pMT;
	}
	/**
	 * @param pMT 是否泡沫痰
	 */
	public void setPMT(Boolean pMT){
		this.pMT = pMT;
	}
	/**
	 * @return yBYW 是否咽部异物
	 */
	public Boolean getYBYW(){
		return this.yBYW;
	}
	/**
	 * @param yBYW 是否咽部异物
	 */
	public void setYBYW(Boolean yBYW){
		this.yBYW = yBYW;
	}
	/**
	 * @return kBDY 是否渴不多饮
	 */
	public Boolean getKBDY(){
		return this.kBDY;
	}
	/**
	 * @param kBDY 是否渴不多饮
	 */
	public void setKBDY(Boolean kBDY){
		this.kBDY = kBDY;
	}
	/**
	 * @return kD 是否口淡
	 */
	public Boolean getKD(){
		return this.kD;
	}
	/**
	 * @param kD 是否口淡
	 */
	public void setKD(Boolean kD){
		this.kD = kD;
	}
	/**
	 * @return kK 是否口苦
	 */
	public Boolean getKK(){
		return this.kK;
	}
	/**
	 * @param kK 是否口苦
	 */
	public void setKK(Boolean kK){
		this.kK = kK;
	}
	/**
	 * @return kT 是否口甜
	 */
	public Boolean getKT(){
		return this.kT;
	}
	/**
	 * @param kT 是否口甜
	 */
	public void setKT(Boolean kT){
		this.kT = kT;
	}
	/**
	 * @return kX 是否口咸
	 */
	public Boolean getKX(){
		return this.kX;
	}
	/**
	 * @param kX 是否口咸
	 */
	public void setKX(Boolean kX){
		this.kX = kX;
	}
	/**
	 * @return kNN 是否口黏腻
	 */
	public Boolean getKNN(){
		return this.kNN;
	}
	/**
	 * @param kNN 是否口黏腻
	 */
	public void setKNN(Boolean kNN){
		this.kNN = kNN;
	}
	/**
	 * @return wGXW 是否五更泻湾
	 */
	public Boolean getWGXW(){
		return this.wGXW;
	}
	/**
	 * @param wGXW 是否五更泻湾
	 */
	public void setWGXW(Boolean wGXW){
		this.wGXW = wGXW;
	}
	/**
	 * @return pBWL 是否排便无力
	 */
	public Boolean getPBWL(){
		return this.pBWL;
	}
	/**
	 * @param pBWL 是否排便无力
	 */
	public void setPBWL(Boolean pBWL){
		this.pBWL = pBWL;
	}
	/**
	 * @return xBDH 是否小便短黄
	 */
	public Boolean getXBDH(){
		return this.xBDH;
	}
	/**
	 * @param xBDH 是否小便短黄
	 */
	public void setXBDH(Boolean xBDH){
		this.xBDH = xBDH;
	}
	/**
	 * @return xBQC 是否小便清长
	 */
	public Boolean getXBQC(){
		return this.xBQC;
	}
	/**
	 * @param xBQC 是否小便清长
	 */
	public void setXBQC(Boolean xBQC){
		this.xBQC = xBQC;
	}
	/**
	 * @return yLBJ 是否余沥不尽
	 */
	public Boolean getYLBJ(){
		return this.yLBJ;
	}
	/**
	 * @param yLBJ 是否余沥不尽
	 */
	public void setYLBJ(Boolean yLBJ){
		this.yLBJ = yLBJ;
	}
	/**
	 * @return wFYL 是否脘腹腰冷
	 */
	public Boolean getWFYL(){
		return this.wFYL;
	}
	/**
	 * @param wFYL 是否脘腹腰冷
	 */
	public void setWFYL(Boolean wFYL){
		this.wFYL = wFYL;
	}
	/**
	 * @return tZCZ 是否肢体沉重
	 */
	public Boolean getTZCZ(){
		return this.tZCZ;
	}
	/**
	 * @param tZCZ 是否肢体沉重
	 */
	public void setTZCZ(Boolean tZCZ){
		this.tZCZ = tZCZ;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("patientCode",getPatientCode())
			.append("XT",getXT())
			.append("XM",getXM())
			.append("XJ",getXJ())
			.append("QD",getQD())
			.append("QC",getQC())
			.append("KS",getKS())
			.append("WHZL",getWHZL())
			.append("PJFL",getPJFL())
			.append("ZH",getZH())
			.append("DH",getDH())
			.append("WXFR",getWXFR())
			.append("LMGS",getLMGS())
			.append("TY",getTY())
			.append("JW",getJW())
			.append("TH",getTH())
			.append("SM",getSM())
			.append("JZYN",getJZYN())
			.append("LZ",getLZ())
			.append("TX",getTX())
			.append("YY",getYY())
			.append("SYBZ",getSYBZ())
			.append("FZ",getFZ())
			.append("AP",getAP())
			.append("AQ",getAQ())
			.append("EXOT",getEXOT())
			.append("BT",getBT())
			.append("BM",getBM())
			.append("YQSR",getYQSR())
			.append("YNPD",getYNPD())
			.append("ZTMM",getZTMM())
			.append("ZTPT",getZTPT())
			.append("PXYX",getPXYX())
			.append("PFCC",getPFCC())
			.append("XTFP",getXTFP())
			.append("BAIT",getBAIT())
			.append("HT",getHT())
			.append("TZDX",getTZDX())
			.append("PMT",getPMT())
			.append("YBYW",getYBYW())
			.append("KBDY",getKBDY())
			.append("KD",getKD())
			.append("KK",getKK())
			.append("KT",getKT())
			.append("KX",getKX())
			.append("KNN",getKNN())
			.append("WGXW",getWGXW())
			.append("PBWL",getPBWL())
			.append("XBDH",getXBDH())
			.append("XBQC",getXBQC())
			.append("YLBJ",getYLBJ())
			.append("WFYL",getWFYL())
			.append("TZCZ",getTZCZ())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getPatientCode())
			.append(getXT())
			.append(getXM())
			.append(getXJ())
			.append(getQD())
			.append(getQC())
			.append(getKS())
			.append(getWHZL())
			.append(getPJFL())
			.append(getZH())
			.append(getDH())
			.append(getWXFR())
			.append(getLMGS())
			.append(getTY())
			.append(getJW())
			.append(getTH())
			.append(getSM())
			.append(getJZYN())
			.append(getLZ())
			.append(getTX())
			.append(getYY())
			.append(getSYBZ())
			.append(getFZ())
			.append(getAP())
			.append(getAQ())
			.append(getEXOT())
			.append(getBT())
			.append(getBM())
			.append(getYQSR())
			.append(getYNPD())
			.append(getZTMM())
			.append(getZTPT())
			.append(getPXYX())
			.append(getPFCC())
			.append(getXTFP())
			.append(getBAIT())
			.append(getHT())
			.append(getTZDX())
			.append(getPMT())
			.append(getYBYW())
			.append(getKBDY())
			.append(getKD())
			.append(getKK())
			.append(getKT())
			.append(getKX())
			.append(getKNN())
			.append(getWGXW())
			.append(getPBWL())
			.append(getXBDH())
			.append(getXBQC())
			.append(getYLBJ())
			.append(getWFYL())
			.append(getTZCZ())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AdmissionDiagnosis == false) return false;
		if(this == obj) return true;
		AdmissionDiagnosis other = (AdmissionDiagnosis)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
