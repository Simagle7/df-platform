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

package cn.df.service.specimen;

import cn.df.common.domain.BaseDomain;
import cn.df.dao.IDFBaseDAO;
import cn.df.dao.specimen.ICheckingAnalysisDAO;
import cn.df.domain.specimen.CheckingAnalysis;
import cn.df.service.specimen.ICheckingAnalysisService;
import cn.df.service.AbstractDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

 /**
 * 《检查分析》 业务逻辑服务类
 * @author Katybaby
 *
 */
@Service("CheckingAnalysisServiceImpl")
public class CheckingAnalysisServiceImpl extends AbstractDFService<IDFBaseDAO<CheckingAnalysis>, CheckingAnalysis> implements ICheckingAnalysisService<IDFBaseDAO<CheckingAnalysis>,CheckingAnalysis>{
    @Autowired
    private ICheckingAnalysisDAO checkingAnalysisDAO;

    @Override
    public IDFBaseDAO<CheckingAnalysis> getDao() {
        return checkingAnalysisDAO;
    }

}