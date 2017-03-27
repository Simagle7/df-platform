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

import cn.df.common.domain.BizData4Page;
import cn.df.common.dto.user.AccountDto;
import cn.df.common.exception.BizException;
import cn.df.common.utils.base.ERRORCODE;
import cn.df.common.utils.base.RETURNCODE;
import cn.df.common.utils.sys.CommonUtils;
import cn.df.common.utils.sys.PageUtils;
import cn.df.dao.IDFBaseDAO;
import cn.df.dao.specimen.IPatientDAO;
import cn.df.domain.specimen.Patient;
import cn.df.param.specimen.PatientParam;
import cn.df.param.specimen.PatientParamEx;
import cn.df.service.AbstractDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 《病人》 业务逻辑服务类
 *
 * @author Katybaby
 */
@Service("PatientServiceImpl")
public class PatientServiceImpl extends AbstractDFService<IDFBaseDAO<Patient>, Patient> implements IPatientService<IDFBaseDAO<Patient>, Patient> {
    @Autowired
    private IPatientDAO patientDAO;

    @Override
    public IDFBaseDAO<Patient> getDao() {
        return patientDAO;
    }


    @Override
    public BizData4Page queryPage(PatientParamEx param, int pageNo, int pageSize) {
        List<Patient> data = patientDAO.queryPageEx(param.toMap(), (pageNo - 1) * pageSize, pageSize);
        int records = patientDAO.countEx(param.toMap());
        return PageUtils.toBizData4Page(data, pageNo, pageSize, records);
    }

    @Override
    public String add(PatientParam param) {
        param.setCode(CommonUtils.getUUID());
        if(this.insertMap(param.toMap()) > 0){
            return RETURNCODE.ADD_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String update(PatientParam param, AccountDto currentUser) {
        return null;
    }

    @Override
    public String queryDiagnose(long id) {
        return null;
    }
}