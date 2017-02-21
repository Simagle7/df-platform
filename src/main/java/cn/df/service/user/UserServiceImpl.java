/*
{*****************************************************************************
{  疾病预测 v1.0													
{  版权信息 (c) 2005-2017 katybaby. 保留所有权利.
{  创建人：  katybaby
{  审查人：
{  模块：用户基础表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2017-02-20  katybaby        新建	
{ 	                                                                     
{*****************************************************************************
*/

package cn.df.service.user;

import cn.df.common.domain.BizData4Page;
import cn.df.common.dto.user.AccountDto;
import cn.df.common.exception.BizException;
import cn.df.common.filter.DFRequestFilter;
import cn.df.common.utils.base.DataStatusEnum;
import cn.df.common.utils.base.ERRORCODE;
import cn.df.common.utils.base.RETURNCODE;
import cn.df.common.utils.sys.CommonUtils;
import cn.df.common.utils.sys.PageUtils;
import cn.df.dao.IDFBaseDAO;
import cn.df.dao.user.IUserDAO;
import cn.df.domain.user.User;
import cn.df.param.user.UserParam;
import cn.df.param.user.UserParamEx;
import cn.df.service.AbstractDFService;
import com.sun.tools.javac.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 /**
 * 《用户基础》 业务逻辑服务类
 * @author katybaby
 *
 */
@Service("UserServiceImpl")
public class UserServiceImpl extends AbstractDFService<IDFBaseDAO<User>, User> implements IUserService<IDFBaseDAO<User>,User>{
    @Autowired   private IUserDAO userDAO;

    @Override
    public IDFBaseDAO<User> getDao() {
        return userDAO;
    }

     @Override
     public String add(UserParam param, AccountDto currentUser) {
        if(!isExists(UserParam.F_Username, param.getUsername())) {
            param.setSalt(RandomStringUtils.randomAlphanumeric(8));
            param.setPassword(CommonUtils.getPassword(param.getPassword(),param.getSalt()));
            param.setCreator(currentUser.getUid());
            param.setCreateDate(System.currentTimeMillis());
            param.setStatus(DataStatusEnum.ENABLED.getValue());
            this.insertMap(param.toMap());
            return RETURNCODE.ADD_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.ACCOUNT_EXISTS.getCode(), ERRORCODE.ACCOUNT_EXISTS.getMessage());
     }

     @Override
     public String update(UserParam param, AccountDto currentUser) {
        param.setLastModifier(currentUser.getUid());
        param.setLastModDate(System.currentTimeMillis());
        if(this.updateMap(param.toMap()) > 0){
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
     }

     @Override
     public String forgetPassword(UserParamEx paramEx, AccountDto currentUser) {
         if (DFRequestFilter.getVerifyCode().equals(paramEx.getVerifyCode())){
//             User user = this.findOne(UserParam.F_Username)
             return  RETURNCODE.UPDATE_COMPLETE.getMessage();
         }else {
             throw new BizException(ERRORCODE.VERIFIEDCODE_ILLEGAL.getCode(), ERRORCODE.VERIFIEDCODE_ILLEGAL.getMessage());
         }
     }

     @Override
     public String resetPassword(UserParam param, AccountDto currentUser) {
         User user = this.findOne(UserParam.F_ID, param.getId());
         param.setPassword(CommonUtils.getPassword(RandomStringUtils.randomNumeric(6), user.getSalt()));
         param.setLastModDate(System.currentTimeMillis());
         param.setLastModifier(currentUser.getUid());
         if (this.updateMap(param.toMap()) > 0){
             return  RETURNCODE.RESET_SUCCES.getMessage();
         }
         throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
     }

     @Override
     public BizData4Page queryPage(UserParam param, Integer pageNo, Integer pageSize) {
         List<User> data = userDAO.queryPageEx(param.toMap(), (pageNo - 1) * pageSize, pageSize);
         int records = userDAO.countEx(param.toMap());
         return PageUtils.toBizData4Page(data, pageNo, pageSize, records);
     }

     @Override
     public String disabledOrEnabled(UserParam param, AccountDto currentUser) {
        param.setLastModDate(System.currentTimeMillis());
        param.setLastModifier(currentUser.getUid());
        if(this.updateMap(param.toMap()) > 0){
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
     }
 }