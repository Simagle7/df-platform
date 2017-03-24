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

package cn.df.dao.specimen;

import cn.df.dao.IDFBaseDAO;
import cn.df.domain.specimen.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 《病人》 数据访问接口
 *
 * @author Katybaby
 */
public interface IPatientDAO extends IDFBaseDAO<Patient> {


    /**
     * 分页查询病人
     * @param conditon  查询条件
     * @param offset    偏移量
     * @param rows      行数
     * @return  返回，分页列表
     */
    List<Patient> queryPageEx(@Param("condition") Map<String, Object> conditon, @Param("offset") int offset, @Param("rows") int rows);

    /**
     * 分页统计病人
     * @param conditon  查询条件
     * @return  返回，统计结果
     */
    int countEx(@Param("condition") Map<String, Object> conditon);
}