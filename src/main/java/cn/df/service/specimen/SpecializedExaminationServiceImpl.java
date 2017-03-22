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

package cn.df.service.specimen;

import cn.df.common.domain.BaseDomain;
import cn.df.dao.IDFBaseDAO;
import cn.df.dao.specimen.ISpecializedExaminationDAO;
import cn.df.domain.specimen.SpecializedExamination;
import cn.df.service.specimen.ISpecializedExaminationService;
import cn.df.service.AbstractDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

 /**
 * 《专科检查》 业务逻辑服务类
 * @author Katybaby
 *
 */
@Service("SpecializedExaminationServiceImpl")
public class SpecializedExaminationServiceImpl extends AbstractDFService<IDFBaseDAO<SpecializedExamination>, SpecializedExamination> implements ISpecializedExaminationService<IDFBaseDAO<SpecializedExamination>,SpecializedExamination>{
    @Autowired
    private ISpecializedExaminationDAO specializedExaminationDAO;

    @Override
    public IDFBaseDAO<SpecializedExamination> getDao() {
        return specializedExaminationDAO;
    }

}