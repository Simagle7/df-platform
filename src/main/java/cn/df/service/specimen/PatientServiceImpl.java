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
{  2017-03-22  Katybaby        新建	
{ 	                                                                     
{*****************************************************************************
*/

package cn.df.service.specimen;

import cn.df.common.algorithm.DBN;
import cn.df.common.domain.BizData4Page;
import cn.df.common.dto.user.AccountDto;
import cn.df.common.exception.BizException;
import cn.df.common.utils.base.ERRORCODE;
import cn.df.common.utils.base.RETURNCODE;
import cn.df.common.utils.sys.CommonUtils;
import cn.df.common.utils.sys.PageUtils;
import cn.df.dao.IDFBaseDAO;
import cn.df.dao.specimen.IPatientDAO;
import cn.df.domain.specimen.*;
import cn.df.param.specimen.*;
import cn.df.service.AbstractDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 《病人》 业务逻辑服务类
 *
 * @author Katybaby
 */
@Service("PatientServiceImpl")
public class PatientServiceImpl extends AbstractDFService<IDFBaseDAO<Patient>, Patient> implements IPatientService<IDFBaseDAO<Patient>, Patient> {
    @Autowired
    private IPatientDAO patientDAO;
    @Autowired
    private IAdmissionDiagnosisService admissionDiagnosisService;
    @Autowired
    private ICheckingAnalysisService checkingAnalysisService;
    @Autowired
    private IColorUltrasoundService ultrasoundService;
    @Autowired
    private IPhysicalExaminationService physicalExaminationService;
    @Autowired
    private ISpecializedExaminationService specializedExaminationService;


    @Override
    public IDFBaseDAO<Patient> getDao() {
        return patientDAO;
    }


    @Override
    public BizData4Page queryPage(PatientParamEx param, int pageNo, int pageSize) {
        //根据条件查询分页数据
        List<Patient> data = patientDAO.queryPageEx(param.toMap(), (pageNo - 1) * pageSize, pageSize);
        //根据条件统计总数
        int records = patientDAO.countEx(param.toMap());
        //封装数据
        return PageUtils.toBizData4Page(data, pageNo, pageSize, records);
    }

    @Override
    public String add(PatientParam param) {
        param.setCode(CommonUtils.getUUID());
        if (this.insertMap(param.toMap()) > 0) {
            return RETURNCODE.ADD_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String update(PatientParam param, AccountDto currentUser) {
        return null;
    }

    @Override
    public double diagnose(long id) {
        //根据病案号查询病人基准数据
        Patient patient = this.findOne(PatientParam.F_ID, id);
        //查询病人入院症见数据，体格检查少数据，专科检查，检查分析数据和彩超数据
        //入院症见数据
        AdmissionDiagnosis admissionDiagnosis = (AdmissionDiagnosis) admissionDiagnosisService.findOne(AdmissionDiagnosisParam.F_PatientCode, patient.getCode());
        //体格检查数据
        PhysicalExamination physicalExamination = (PhysicalExamination) physicalExaminationService.findOne(PhysicalExaminationParam.F_PatientCode, patient.getCode());
        //专科检查数据
        SpecializedExamination specializedExamination = (SpecializedExamination) specializedExaminationService.findOne(SpecializedExaminationParam.F_PatientCode, patient.getCode());
        //检查分析数据
        CheckingAnalysis checkingAnalysis = (CheckingAnalysis) checkingAnalysisService.findOne(CheckingAnalysisParam.F_PatientCode, patient.getCode());
        //彩超数据
        ColorUltrasound colorUltrasound = (ColorUltrasound) ultrasoundService.findOne(ColorUltrasoundParam.F_PatientCode, patient.getCode());

        //封装当前病人数据
        Map<String, Object> params = new HashMap<>();
        params.put("admissionDiagnosis", admissionDiagnosis);
        params.put("physicalExamination", physicalExamination);
        params.put("specializedExamination", specializedExamination);
        params.put("checkingAnalysis", checkingAnalysis);
        params.put("colorUltrasound", colorUltrasound);

        //调用DBN算法进行计算概率
        double probability = Double.parseDouble(new DBN().getProbability(patient, params));
        //数据采集
        patientDAO.updateProbability(probability, patient.getId());
        // 得出最终概率并返回
        return 1 - probability;
    }
}