/*
{*****************************************************************************
{  疾病预测 v1.0													
{  版权信息 (c) 2005-2017 Katybaby. 保留所有权利.
{  创建人：  Katybaby
{  审查人：
{  模块：检查分析表											
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
 * 《检查分析》 查询参数实体
 * @author Katybaby
 *
 */
public class CheckingAnalysisParam extends BaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——病人代码
	*/
	public static final String F_PatientCode="patientCode";
	/**
	*字段常量——心率
	*/
	public static final String F_XL="XL";
	/**
	*字段常量——白细胞
	*/
	public static final String F_BXB="BXB";
	/**
	*字段常量——中性粒细胞百分比
	*/
	public static final String F_ZXLXBBFB="ZXLXBBFB";
	/**
	*字段常量——淋巴细胞百分比
	*/
	public static final String F_LBXBBFB="LBXBBFB";
	/**
	*字段常量——单核细胞百分比
	*/
	public static final String F_DHXBBFB="DHXBBFB";
	/**
	*字段常量——中性粒细胞数
	*/
	public static final String F_ZXLXBS="ZXLXBS";
	/**
	*字段常量——淋巴细胞数
	*/
	public static final String F_LBXBS="LBXBS";
	/**
	*字段常量——单核细胞数
	*/
	public static final String F_DHXBS="DHXBS";
	/**
	*字段常量——红细胞数
	*/
	public static final String F_HXBS="HXBS";
	/**
	*字段常量——血红蛋白
	*/
	public static final String F_XHDB="XHDB";
	/**
	*字段常量——红细胞压积
	*/
	public static final String F_HXBJY="HXBJY";
	/**
	*字段常量——平均红细胞体积
	*/
	public static final String F_PJHXBTJ="PJHXBTJ";
	/**
	*字段常量——平均血红蛋白量
	*/
	public static final String F_PJXHDBL="PJXHDBL";
	/**
	*字段常量——红细胞分布宽度
	*/
	public static final String F_HXBFBKD="HXBFBKD";
	/**
	*字段常量——血小板
	*/
	public static final String F_XXB="XXB";
	/**
	*字段常量——血小板平均体积
	*/
	public static final String F_XXBPJTJ="XXBPJTJ";
	/**
	*字段常量——血小板积压
	*/
	public static final String F_XXBJY="XXBJY";
	/**
	*字段常量——血小板分布宽度
	*/
	public static final String F_XXBFBKD="XXBFBKD";
	/**
	*字段常量——尿常规比重
	*/
	public static final String F_NCGBZ="NCGBZ";
	/**
	*字段常量——尿白细胞数
	*/
	public static final String F_NBXBS="NBXBS";
	/**
	*字段常量——尿红细胞数
	*/
	public static final String F_NHXBS="NHXBS";
	/**
	*字段常量——前白蛋白
	*/
	public static final String F_QBDB="QBDB";
	/**
	*字段常量——谷丙转氨酶
	*/
	public static final String F_GBZAM="GBZAM";
	/**
	*字段常量——总蛋白
	*/
	public static final String F_ZDB="ZDB";
	/**
	*字段常量——白蛋白
	*/
	public static final String F_BDB="BDB";
	/**
	*字段常量——白球蛋白比值
	*/
	public static final String F_BQDBBZ="BQDBBZ";
	/**
	*字段常量——Y-谷氨酰转肽酶
	*/
	public static final String F_YGAXZTM="YGAXZTM";
	/**
	*字段常量——碱性磷酸酶
	*/
	public static final String F_JXLSM="JXLSM";
	/**
	*字段常量——总胆红素
	*/
	public static final String F_ZDHS="ZDHS";
	/**
	*字段常量——直接胆红素
	*/
	public static final String F_ZJDHS="ZJDHS";
	/**
	*字段常量——总胆汁酸
	*/
	public static final String F_ZDZS="ZDZS";
	/**
	*字段常量——尿素
	*/
	public static final String F_SS="SS";
	/**
	*字段常量——肌酐
	*/
	public static final String F_JG="JG";
	/**
	*字段常量——总二氧化碳
	*/
	public static final String F_ZCO2="ZCO2";
	/**
	*字段常量——尿酸
	*/
	public static final String F_NS="NS";
	/**
	*字段常量——葡萄糖
	*/
	public static final String F_PTT="PTT";
	/**
	*字段常量——总胆固醇
	*/
	public static final String F_ZDGC="ZDGC";
	/**
	*字段常量——甘油三酯
	*/
	public static final String F_GYSZ="GYSZ";
	/**
	*字段常量——高密度脂蛋白胆固醇
	*/
	public static final String F_GMDZDBD="GMDZDBD";
	/**
	*字段常量——低密度脂蛋白胆固醇
	*/
	public static final String F_DMDZDBD="DMDZDBD";
	/**
	*字段常量——脂蛋白a
	*/
	public static final String F_ZDBa="ZDBa";
	/**
	*字段常量——肌酸激酶
	*/
	public static final String F_JSJM="JSJM";
	/**
	*字段常量——肌酸激酶同工酶
	*/
	public static final String F_JSJMTGM="JSJMTGM";
	/**
	*字段常量——乳酸脱氢酶
	*/
	public static final String F_RSTQM="RSTQM";
	/**
	*字段常量——K+
	*/
	public static final String F_KPlus="KPlus";
	/**
	*字段常量——Na+
	*/
	public static final String F_NaPlus="NaPlus";
	/**
	*字段常量——Cl-
	*/
	public static final String F_ClNe="ClNe";
	/**
	*字段常量——Ca2+
	*/
	public static final String F_Ca2Plus="Ca2Plus";
	/**
	*字段常量——凝血酶原时间
	*/
	public static final String F_NXMYSJ="NXMYSJ";
	/**
	*字段常量——凝血酶原活动度
	*/
	public static final String F_NXMYHDD="NXMYHDD";
	/**
	*字段常量——国际标准化比值
	*/
	public static final String F_GJBZHBZ="GJBZHBZ";
	/**
	*字段常量——纤维蛋白原
	*/
	public static final String F_XWDBY="XWDBY";
	/**
	*字段常量——活化部分凝血活酶时间
	*/
	public static final String F_HHBFNXHMSJ="HHBFNXHMSJ";
	/**
	*字段常量——D-2聚体
	*/
	public static final String F_D2JT="D2JT";
	/**
	*字段常量——促甲状腺激素
	*/
	public static final String F_CJZXJS="CJZXJS";
	/**
	*字段常量——血清游离T3
	*/
	public static final String F_XQYLT3="XQYLT3";
	/**
	*字段常量——血清游离T4
	*/
	public static final String F_XQYLT4="XQYLT4";
	/**
	*字段常量——肌钙蛋白定量
	*/
	public static final String F_JGDBDL="JGDBDL";
	/**
	*字段常量——BNP
	*/
	public static final String F_BNP="BNP";
	/**
	*字段常量——NTpro-BNP
	*/
	public static final String F_NTproBNP="NTproBNP";
	/**
	*字段常量——hs-CRP
	*/
	public static final String F_HsCRP="hsCRP";
	/**
	*字段常量——CRP
	*/
	public static final String F_CRP="CRP";
	
	private String patientCode; //病人代码
	private Double xL; //心率
	private Double bXB; //白细胞
	private Double zXLXBBFB; //中性粒细胞百分比
	private Double lBXBBFB; //淋巴细胞百分比
	private Double dHXBBFB; //单核细胞百分比
	private Double zXLXBS; //中性粒细胞数
	private Double lBXBS; //淋巴细胞数
	private Double dHXBS; //单核细胞数
	private Double hXBS; //红细胞数
	private Double xHDB; //血红蛋白
	private Double hXBJY; //红细胞压积
	private Double pJHXBTJ; //平均红细胞体积
	private Double pJXHDBL; //平均血红蛋白量
	private Double hXBFBKD; //红细胞分布宽度
	private Double xXB; //血小板
	private Double xXBPJTJ; //血小板平均体积
	private Double xXBJY; //血小板积压
	private Double xXBFBKD; //血小板分布宽度
	private Double nCGBZ; //尿常规比重
	private Double nBXBS; //尿白细胞数
	private Double nHXBS; //尿红细胞数
	private Double qBDB; //前白蛋白
	private Double gBZAM; //谷丙转氨酶
	private Double zDB; //总蛋白
	private Double bDB; //白蛋白
	private Double bQDBBZ; //白球蛋白比值
	private Double yGAXZTM; //Y-谷氨酰转肽酶
	private Double jXLSM; //碱性磷酸酶
	private Double zDHS; //总胆红素
	private Double zJDHS; //直接胆红素
	private Double zDZS; //总胆汁酸
	private Double sS; //尿素
	private Double jG; //肌酐
	private Double zCO2; //总二氧化碳
	private Double nS; //尿酸
	private Double pTT; //葡萄糖
	private Double zDGC; //总胆固醇
	private Double gYSZ; //甘油三酯
	private Double gMDZDBD; //高密度脂蛋白胆固醇
	private Double dMDZDBD; //低密度脂蛋白胆固醇
	private Double zDBa; //脂蛋白a
	private Double jSJM; //肌酸激酶
	private Double jSJMTGM; //肌酸激酶同工酶
	private Double rSTQM; //乳酸脱氢酶
	private Double kPlus; //K+
	private Double naPlus; //Na+
	private Double clNe; //Cl-
	private Double ca2Plus; //Ca2+
	private Double nXMYSJ; //凝血酶原时间
	private Double nXMYHDD; //凝血酶原活动度
	private Double gJBZHBZ; //国际标准化比值
	private Double xWDBY; //纤维蛋白原
	private Double hHBFNXHMSJ; //活化部分凝血活酶时间
	private Double d2JT; //D-2聚体
	private Double cJZXJS; //促甲状腺激素
	private Double xQYLT3; //血清游离T3
	private Double xQYLT4; //血清游离T4
	private Double jGDBDL; //肌钙蛋白定量
	private Double bNP; //BNP
	private Double nTproBNP; //NTpro-BNP
	private Double hsCRP; //hs-CRP
	private Double cRP; //CRP
    
	/**
	 *默认空构造函数
	 */
	public CheckingAnalysisParam() {
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
	 * @return xL 心率
	 */
	public Double getXL(){
		return this.xL;
	}
	/**
	 * @param xL 心率
	 */
	public void setXL(Double xL){
		this.xL = xL;
	}
	/**
	 * @return bXB 白细胞
	 */
	public Double getBXB(){
		return this.bXB;
	}
	/**
	 * @param bXB 白细胞
	 */
	public void setBXB(Double bXB){
		this.bXB = bXB;
	}
	/**
	 * @return zXLXBBFB 中性粒细胞百分比
	 */
	public Double getZXLXBBFB(){
		return this.zXLXBBFB;
	}
	/**
	 * @param zXLXBBFB 中性粒细胞百分比
	 */
	public void setZXLXBBFB(Double zXLXBBFB){
		this.zXLXBBFB = zXLXBBFB;
	}
	/**
	 * @return lBXBBFB 淋巴细胞百分比
	 */
	public Double getLBXBBFB(){
		return this.lBXBBFB;
	}
	/**
	 * @param lBXBBFB 淋巴细胞百分比
	 */
	public void setLBXBBFB(Double lBXBBFB){
		this.lBXBBFB = lBXBBFB;
	}
	/**
	 * @return dHXBBFB 单核细胞百分比
	 */
	public Double getDHXBBFB(){
		return this.dHXBBFB;
	}
	/**
	 * @param dHXBBFB 单核细胞百分比
	 */
	public void setDHXBBFB(Double dHXBBFB){
		this.dHXBBFB = dHXBBFB;
	}
	/**
	 * @return zXLXBS 中性粒细胞数
	 */
	public Double getZXLXBS(){
		return this.zXLXBS;
	}
	/**
	 * @param zXLXBS 中性粒细胞数
	 */
	public void setZXLXBS(Double zXLXBS){
		this.zXLXBS = zXLXBS;
	}
	/**
	 * @return lBXBS 淋巴细胞数
	 */
	public Double getLBXBS(){
		return this.lBXBS;
	}
	/**
	 * @param lBXBS 淋巴细胞数
	 */
	public void setLBXBS(Double lBXBS){
		this.lBXBS = lBXBS;
	}
	/**
	 * @return dHXBS 单核细胞数
	 */
	public Double getDHXBS(){
		return this.dHXBS;
	}
	/**
	 * @param dHXBS 单核细胞数
	 */
	public void setDHXBS(Double dHXBS){
		this.dHXBS = dHXBS;
	}
	/**
	 * @return hXBS 红细胞数
	 */
	public Double getHXBS(){
		return this.hXBS;
	}
	/**
	 * @param hXBS 红细胞数
	 */
	public void setHXBS(Double hXBS){
		this.hXBS = hXBS;
	}
	/**
	 * @return xHDB 血红蛋白
	 */
	public Double getXHDB(){
		return this.xHDB;
	}
	/**
	 * @param xHDB 血红蛋白
	 */
	public void setXHDB(Double xHDB){
		this.xHDB = xHDB;
	}
	/**
	 * @return hXBJY 红细胞压积
	 */
	public Double getHXBJY(){
		return this.hXBJY;
	}
	/**
	 * @param hXBJY 红细胞压积
	 */
	public void setHXBJY(Double hXBJY){
		this.hXBJY = hXBJY;
	}
	/**
	 * @return pJHXBTJ 平均红细胞体积
	 */
	public Double getPJHXBTJ(){
		return this.pJHXBTJ;
	}
	/**
	 * @param pJHXBTJ 平均红细胞体积
	 */
	public void setPJHXBTJ(Double pJHXBTJ){
		this.pJHXBTJ = pJHXBTJ;
	}
	/**
	 * @return pJXHDBL 平均血红蛋白量
	 */
	public Double getPJXHDBL(){
		return this.pJXHDBL;
	}
	/**
	 * @param pJXHDBL 平均血红蛋白量
	 */
	public void setPJXHDBL(Double pJXHDBL){
		this.pJXHDBL = pJXHDBL;
	}
	/**
	 * @return hXBFBKD 红细胞分布宽度
	 */
	public Double getHXBFBKD(){
		return this.hXBFBKD;
	}
	/**
	 * @param hXBFBKD 红细胞分布宽度
	 */
	public void setHXBFBKD(Double hXBFBKD){
		this.hXBFBKD = hXBFBKD;
	}
	/**
	 * @return xXB 血小板
	 */
	public Double getXXB(){
		return this.xXB;
	}
	/**
	 * @param xXB 血小板
	 */
	public void setXXB(Double xXB){
		this.xXB = xXB;
	}
	/**
	 * @return xXBPJTJ 血小板平均体积
	 */
	public Double getXXBPJTJ(){
		return this.xXBPJTJ;
	}
	/**
	 * @param xXBPJTJ 血小板平均体积
	 */
	public void setXXBPJTJ(Double xXBPJTJ){
		this.xXBPJTJ = xXBPJTJ;
	}
	/**
	 * @return xXBJY 血小板积压
	 */
	public Double getXXBJY(){
		return this.xXBJY;
	}
	/**
	 * @param xXBJY 血小板积压
	 */
	public void setXXBJY(Double xXBJY){
		this.xXBJY = xXBJY;
	}
	/**
	 * @return xXBFBKD 血小板分布宽度
	 */
	public Double getXXBFBKD(){
		return this.xXBFBKD;
	}
	/**
	 * @param xXBFBKD 血小板分布宽度
	 */
	public void setXXBFBKD(Double xXBFBKD){
		this.xXBFBKD = xXBFBKD;
	}
	/**
	 * @return nCGBZ 尿常规比重
	 */
	public Double getNCGBZ(){
		return this.nCGBZ;
	}
	/**
	 * @param nCGBZ 尿常规比重
	 */
	public void setNCGBZ(Double nCGBZ){
		this.nCGBZ = nCGBZ;
	}
	/**
	 * @return nBXBS 尿白细胞数
	 */
	public Double getNBXBS(){
		return this.nBXBS;
	}
	/**
	 * @param nBXBS 尿白细胞数
	 */
	public void setNBXBS(Double nBXBS){
		this.nBXBS = nBXBS;
	}
	/**
	 * @return nHXBS 尿红细胞数
	 */
	public Double getNHXBS(){
		return this.nHXBS;
	}
	/**
	 * @param nHXBS 尿红细胞数
	 */
	public void setNHXBS(Double nHXBS){
		this.nHXBS = nHXBS;
	}
	/**
	 * @return qBDB 前白蛋白
	 */
	public Double getQBDB(){
		return this.qBDB;
	}
	/**
	 * @param qBDB 前白蛋白
	 */
	public void setQBDB(Double qBDB){
		this.qBDB = qBDB;
	}
	/**
	 * @return gBZAM 谷丙转氨酶
	 */
	public Double getGBZAM(){
		return this.gBZAM;
	}
	/**
	 * @param gBZAM 谷丙转氨酶
	 */
	public void setGBZAM(Double gBZAM){
		this.gBZAM = gBZAM;
	}
	/**
	 * @return zDB 总蛋白
	 */
	public Double getZDB(){
		return this.zDB;
	}
	/**
	 * @param zDB 总蛋白
	 */
	public void setZDB(Double zDB){
		this.zDB = zDB;
	}
	/**
	 * @return bDB 白蛋白
	 */
	public Double getBDB(){
		return this.bDB;
	}
	/**
	 * @param bDB 白蛋白
	 */
	public void setBDB(Double bDB){
		this.bDB = bDB;
	}
	/**
	 * @return bQDBBZ 白球蛋白比值
	 */
	public Double getBQDBBZ(){
		return this.bQDBBZ;
	}
	/**
	 * @param bQDBBZ 白球蛋白比值
	 */
	public void setBQDBBZ(Double bQDBBZ){
		this.bQDBBZ = bQDBBZ;
	}
	/**
	 * @return yGAXZTM Y-谷氨酰转肽酶
	 */
	public Double getYGAXZTM(){
		return this.yGAXZTM;
	}
	/**
	 * @param yGAXZTM Y-谷氨酰转肽酶
	 */
	public void setYGAXZTM(Double yGAXZTM){
		this.yGAXZTM = yGAXZTM;
	}
	/**
	 * @return jXLSM 碱性磷酸酶
	 */
	public Double getJXLSM(){
		return this.jXLSM;
	}
	/**
	 * @param jXLSM 碱性磷酸酶
	 */
	public void setJXLSM(Double jXLSM){
		this.jXLSM = jXLSM;
	}
	/**
	 * @return zDHS 总胆红素
	 */
	public Double getZDHS(){
		return this.zDHS;
	}
	/**
	 * @param zDHS 总胆红素
	 */
	public void setZDHS(Double zDHS){
		this.zDHS = zDHS;
	}
	/**
	 * @return zJDHS 直接胆红素
	 */
	public Double getZJDHS(){
		return this.zJDHS;
	}
	/**
	 * @param zJDHS 直接胆红素
	 */
	public void setZJDHS(Double zJDHS){
		this.zJDHS = zJDHS;
	}
	/**
	 * @return zDZS 总胆汁酸
	 */
	public Double getZDZS(){
		return this.zDZS;
	}
	/**
	 * @param zDZS 总胆汁酸
	 */
	public void setZDZS(Double zDZS){
		this.zDZS = zDZS;
	}
	/**
	 * @return sS 尿素
	 */
	public Double getSS(){
		return this.sS;
	}
	/**
	 * @param sS 尿素
	 */
	public void setSS(Double sS){
		this.sS = sS;
	}
	/**
	 * @return jG 肌酐
	 */
	public Double getJG(){
		return this.jG;
	}
	/**
	 * @param jG 肌酐
	 */
	public void setJG(Double jG){
		this.jG = jG;
	}
	/**
	 * @return zCO2 总二氧化碳
	 */
	public Double getZCO2(){
		return this.zCO2;
	}
	/**
	 * @param zCO2 总二氧化碳
	 */
	public void setZCO2(Double zCO2){
		this.zCO2 = zCO2;
	}
	/**
	 * @return nS 尿酸
	 */
	public Double getNS(){
		return this.nS;
	}
	/**
	 * @param nS 尿酸
	 */
	public void setNS(Double nS){
		this.nS = nS;
	}
	/**
	 * @return pTT 葡萄糖
	 */
	public Double getPTT(){
		return this.pTT;
	}
	/**
	 * @param pTT 葡萄糖
	 */
	public void setPTT(Double pTT){
		this.pTT = pTT;
	}
	/**
	 * @return zDGC 总胆固醇
	 */
	public Double getZDGC(){
		return this.zDGC;
	}
	/**
	 * @param zDGC 总胆固醇
	 */
	public void setZDGC(Double zDGC){
		this.zDGC = zDGC;
	}
	/**
	 * @return gYSZ 甘油三酯
	 */
	public Double getGYSZ(){
		return this.gYSZ;
	}
	/**
	 * @param gYSZ 甘油三酯
	 */
	public void setGYSZ(Double gYSZ){
		this.gYSZ = gYSZ;
	}
	/**
	 * @return gMDZDBD 高密度脂蛋白胆固醇
	 */
	public Double getGMDZDBD(){
		return this.gMDZDBD;
	}
	/**
	 * @param gMDZDBD 高密度脂蛋白胆固醇
	 */
	public void setGMDZDBD(Double gMDZDBD){
		this.gMDZDBD = gMDZDBD;
	}
	/**
	 * @return dMDZDBD 低密度脂蛋白胆固醇
	 */
	public Double getDMDZDBD(){
		return this.dMDZDBD;
	}
	/**
	 * @param dMDZDBD 低密度脂蛋白胆固醇
	 */
	public void setDMDZDBD(Double dMDZDBD){
		this.dMDZDBD = dMDZDBD;
	}
	/**
	 * @return zDBa 脂蛋白a
	 */
	public Double getZDBa(){
		return this.zDBa;
	}
	/**
	 * @param zDBa 脂蛋白a
	 */
	public void setZDBa(Double zDBa){
		this.zDBa = zDBa;
	}
	/**
	 * @return jSJM 肌酸激酶
	 */
	public Double getJSJM(){
		return this.jSJM;
	}
	/**
	 * @param jSJM 肌酸激酶
	 */
	public void setJSJM(Double jSJM){
		this.jSJM = jSJM;
	}
	/**
	 * @return jSJMTGM 肌酸激酶同工酶
	 */
	public Double getJSJMTGM(){
		return this.jSJMTGM;
	}
	/**
	 * @param jSJMTGM 肌酸激酶同工酶
	 */
	public void setJSJMTGM(Double jSJMTGM){
		this.jSJMTGM = jSJMTGM;
	}
	/**
	 * @return rSTQM 乳酸脱氢酶
	 */
	public Double getRSTQM(){
		return this.rSTQM;
	}
	/**
	 * @param rSTQM 乳酸脱氢酶
	 */
	public void setRSTQM(Double rSTQM){
		this.rSTQM = rSTQM;
	}
	/**
	 * @return kPlus K+
	 */
	public Double getKPlus(){
		return this.kPlus;
	}
	/**
	 * @param kPlus K+
	 */
	public void setKPlus(Double kPlus){
		this.kPlus = kPlus;
	}
	/**
	 * @return naPlus Na+
	 */
	public Double getNaPlus(){
		return this.naPlus;
	}
	/**
	 * @param naPlus Na+
	 */
	public void setNaPlus(Double naPlus){
		this.naPlus = naPlus;
	}
	/**
	 * @return clNe Cl-
	 */
	public Double getClNe(){
		return this.clNe;
	}
	/**
	 * @param clNe Cl-
	 */
	public void setClNe(Double clNe){
		this.clNe = clNe;
	}
	/**
	 * @return ca2Plus Ca2+
	 */
	public Double getCa2Plus(){
		return this.ca2Plus;
	}
	/**
	 * @param ca2Plus Ca2+
	 */
	public void setCa2Plus(Double ca2Plus){
		this.ca2Plus = ca2Plus;
	}
	/**
	 * @return nXMYSJ 凝血酶原时间
	 */
	public Double getNXMYSJ(){
		return this.nXMYSJ;
	}
	/**
	 * @param nXMYSJ 凝血酶原时间
	 */
	public void setNXMYSJ(Double nXMYSJ){
		this.nXMYSJ = nXMYSJ;
	}
	/**
	 * @return nXMYHDD 凝血酶原活动度
	 */
	public Double getNXMYHDD(){
		return this.nXMYHDD;
	}
	/**
	 * @param nXMYHDD 凝血酶原活动度
	 */
	public void setNXMYHDD(Double nXMYHDD){
		this.nXMYHDD = nXMYHDD;
	}
	/**
	 * @return gJBZHBZ 国际标准化比值
	 */
	public Double getGJBZHBZ(){
		return this.gJBZHBZ;
	}
	/**
	 * @param gJBZHBZ 国际标准化比值
	 */
	public void setGJBZHBZ(Double gJBZHBZ){
		this.gJBZHBZ = gJBZHBZ;
	}
	/**
	 * @return xWDBY 纤维蛋白原
	 */
	public Double getXWDBY(){
		return this.xWDBY;
	}
	/**
	 * @param xWDBY 纤维蛋白原
	 */
	public void setXWDBY(Double xWDBY){
		this.xWDBY = xWDBY;
	}
	/**
	 * @return hHBFNXHMSJ 活化部分凝血活酶时间
	 */
	public Double getHHBFNXHMSJ(){
		return this.hHBFNXHMSJ;
	}
	/**
	 * @param hHBFNXHMSJ 活化部分凝血活酶时间
	 */
	public void setHHBFNXHMSJ(Double hHBFNXHMSJ){
		this.hHBFNXHMSJ = hHBFNXHMSJ;
	}
	/**
	 * @return d2JT D-2聚体
	 */
	public Double getD2JT(){
		return this.d2JT;
	}
	/**
	 * @param d2JT D-2聚体
	 */
	public void setD2JT(Double d2JT){
		this.d2JT = d2JT;
	}
	/**
	 * @return cJZXJS 促甲状腺激素
	 */
	public Double getCJZXJS(){
		return this.cJZXJS;
	}
	/**
	 * @param cJZXJS 促甲状腺激素
	 */
	public void setCJZXJS(Double cJZXJS){
		this.cJZXJS = cJZXJS;
	}
	/**
	 * @return xQYLT3 血清游离T3
	 */
	public Double getXQYLT3(){
		return this.xQYLT3;
	}
	/**
	 * @param xQYLT3 血清游离T3
	 */
	public void setXQYLT3(Double xQYLT3){
		this.xQYLT3 = xQYLT3;
	}
	/**
	 * @return xQYLT4 血清游离T4
	 */
	public Double getXQYLT4(){
		return this.xQYLT4;
	}
	/**
	 * @param xQYLT4 血清游离T4
	 */
	public void setXQYLT4(Double xQYLT4){
		this.xQYLT4 = xQYLT4;
	}
	/**
	 * @return jGDBDL 肌钙蛋白定量
	 */
	public Double getJGDBDL(){
		return this.jGDBDL;
	}
	/**
	 * @param jGDBDL 肌钙蛋白定量
	 */
	public void setJGDBDL(Double jGDBDL){
		this.jGDBDL = jGDBDL;
	}
	/**
	 * @return bNP BNP
	 */
	public Double getBNP(){
		return this.bNP;
	}
	/**
	 * @param bNP BNP
	 */
	public void setBNP(Double bNP){
		this.bNP = bNP;
	}
	/**
	 * @return nTproBNP NTpro-BNP
	 */
	public Double getNTproBNP(){
		return this.nTproBNP;
	}
	/**
	 * @param nTproBNP NTpro-BNP
	 */
	public void setNTproBNP(Double nTproBNP){
		this.nTproBNP = nTproBNP;
	}
	/**
	 * @return hsCRP hs-CRP
	 */
	public Double getHsCRP(){
		return this.hsCRP;
	}
	/**
	 * @param hsCRP hs-CRP
	 */
	public void setHsCRP(Double hsCRP){
		this.hsCRP = hsCRP;
	}
	/**
	 * @return cRP CRP
	 */
	public Double getCRP(){
		return this.cRP;
	}
	/**
	 * @param cRP CRP
	 */
	public void setCRP(Double cRP){
		this.cRP = cRP;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("patientCode",getPatientCode())
			.append("XL",getXL())
			.append("BXB",getBXB())
			.append("ZXLXBBFB",getZXLXBBFB())
			.append("LBXBBFB",getLBXBBFB())
			.append("DHXBBFB",getDHXBBFB())
			.append("ZXLXBS",getZXLXBS())
			.append("LBXBS",getLBXBS())
			.append("DHXBS",getDHXBS())
			.append("HXBS",getHXBS())
			.append("XHDB",getXHDB())
			.append("HXBJY",getHXBJY())
			.append("PJHXBTJ",getPJHXBTJ())
			.append("PJXHDBL",getPJXHDBL())
			.append("HXBFBKD",getHXBFBKD())
			.append("XXB",getXXB())
			.append("XXBPJTJ",getXXBPJTJ())
			.append("XXBJY",getXXBJY())
			.append("XXBFBKD",getXXBFBKD())
			.append("NCGBZ",getNCGBZ())
			.append("NBXBS",getNBXBS())
			.append("NHXBS",getNHXBS())
			.append("QBDB",getQBDB())
			.append("GBZAM",getGBZAM())
			.append("ZDB",getZDB())
			.append("BDB",getBDB())
			.append("BQDBBZ",getBQDBBZ())
			.append("YGAXZTM",getYGAXZTM())
			.append("JXLSM",getJXLSM())
			.append("ZDHS",getZDHS())
			.append("ZJDHS",getZJDHS())
			.append("ZDZS",getZDZS())
			.append("SS",getSS())
			.append("JG",getJG())
			.append("ZCO2",getZCO2())
			.append("NS",getNS())
			.append("PTT",getPTT())
			.append("ZDGC",getZDGC())
			.append("GYSZ",getGYSZ())
			.append("GMDZDBD",getGMDZDBD())
			.append("DMDZDBD",getDMDZDBD())
			.append("ZDBa",getZDBa())
			.append("JSJM",getJSJM())
			.append("JSJMTGM",getJSJMTGM())
			.append("RSTQM",getRSTQM())
			.append("KPlus",getKPlus())
			.append("NaPlus",getNaPlus())
			.append("ClNe",getClNe())
			.append("Ca2Plus",getCa2Plus())
			.append("NXMYSJ",getNXMYSJ())
			.append("NXMYHDD",getNXMYHDD())
			.append("GJBZHBZ",getGJBZHBZ())
			.append("XWDBY",getXWDBY())
			.append("HHBFNXHMSJ",getHHBFNXHMSJ())
			.append("D2JT",getD2JT())
			.append("CJZXJS",getCJZXJS())
			.append("XQYLT3",getXQYLT3())
			.append("XQYLT4",getXQYLT4())
			.append("JGDBDL",getJGDBDL())
			.append("BNP",getBNP())
			.append("NTproBNP",getNTproBNP())
			.append("hsCRP",getHsCRP())
			.append("CRP",getCRP())
			.toString();
	}
	
}
