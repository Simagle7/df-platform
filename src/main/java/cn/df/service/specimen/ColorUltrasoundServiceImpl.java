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

package cn.df.service.specimen;

import cn.df.common.domain.BaseDomain;
import cn.df.dao.IDFBaseDAO;
import cn.df.dao.specimen.IColorUltrasoundDAO;
import cn.df.domain.specimen.ColorUltrasound;
import cn.df.service.specimen.IColorUltrasoundService;
import cn.df.service.AbstractDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

 /**
 * 《彩超》 业务逻辑服务类
 * @author Katybaby
 *
 */
@Service("ColorUltrasoundServiceImpl")
public class ColorUltrasoundServiceImpl extends AbstractDFService<IDFBaseDAO<ColorUltrasound>, ColorUltrasound> implements IColorUltrasoundService<IDFBaseDAO<ColorUltrasound>,ColorUltrasound>{
    @Autowired
    private IColorUltrasoundDAO colorUltrasoundDAO;

    @Override
    public IDFBaseDAO<ColorUltrasound> getDao() {
        return colorUltrasoundDAO;
    }

}