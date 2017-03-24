package cn.df.controller.specimen;

import cn.df.common.domain.BizData4Page;
import cn.df.common.exception.BizException;
import cn.df.common.utils.base.ERRORCODE;
import cn.df.common.utils.base.RETURNCODE;
import cn.df.domain.specimen.Patient;
import cn.df.param.specimen.PatientParam;
import cn.df.param.specimen.PatientParamEx;
import cn.df.service.specimen.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * Created by KatyBaby on 2017/3/22.
 * 病人管理
 */
@Controller
@RequestMapping(value = "/cn/df/patient")
public class PatientController {
    
    @Autowired
    private IPatientService patientService;

    /**
     * 分页查询
     * @param param     查询参数
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return  分页结果
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage", method = RequestMethod.POST)
    public BizData4Page queryPage(PatientParamEx param, @RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize){
        return patientService.queryPage(param, pageNo, pageSize);
    }

    /**
     * 添加一个病人
     * @param param 病人信息
     * @return 返回，操作码   
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(PatientParam param){
        return patientService.add(param);
    }

    /**
     * 查找一个病人
     * @param id    病人id
     * @return 返回，用户信息实体
     */
    @ResponseBody
    @RequestMapping(value = "/queryOne")
    public Patient queryOne(long id){
        return (Patient) patientService.findOne(PatientParam.F_ID, id);
    }

    /**
     * 更新一个病人
     * @param param 病人信息
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public String update(PatientParam param){
        if(patientService.updateMap(param.toMap()) > 0){
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }


    /**
     * 删除一个病人
     * @param id    病人id
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(Long id){
        if (patientService.deleteById(id) > 0){
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getMessage(), ERRORCODE.OPERATION_FAIL.getCode());
    }

    /**
     * 批量删除病人
     * @param ids 病人id列表
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteByIds")
    public String deleteByIds(Long[] ids){
        if (patientService.deleteByIds(Arrays.asList(ids)) != 0) {
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        } else {
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }
}
