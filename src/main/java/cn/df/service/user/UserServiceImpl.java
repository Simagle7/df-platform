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
import cn.df.common.listener.DFRequestListener;
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
import com.alibaba.druid.util.StringUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
/**
 * 《用户基础》 业务逻辑服务类
 * @author katybaby
 *
 */
@Service("UserServiceImpl")
public class UserServiceImpl extends AbstractDFService<IDFBaseDAO<User>, User> implements IUserService<IDFBaseDAO<User>,User>{
    @Autowired   private IUserDAO userDAO;


    @Override
    public String isLogin(HttpServletRequest request, HttpServletResponse response) {
        //如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.isAuthenticated());
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        //根据shiro返回的异常类路径判断，抛出指定异常信息
        if(!StringUtils.isEmpty(exceptionClassName)){
            if(UnknownAccountException.class.getName().equals(exceptionClassName)){    //账号不存在
                throw new BizException(ERRORCODE.ACCOUNT_ILLEGAL.getCode(), ERRORCODE.ACCOUNT_ILLEGAL.getMessage());
            }else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)){     //账号密码不匹配
                throw new BizException(ERRORCODE.ACCOUNT_PASSWD_UNMATCH.getCode(), ERRORCODE.ACCOUNT_PASSWD_UNMATCH.getMessage());
            }else {// 系统未知异常
                throw new RuntimeException();
            }
        }
        //从shiro的session给货品获取到session并进行设置
//        Subject subject = SecurityUtils.getSubject();
        //得到用户信息
//        AccountDto accountDto = (AccountDto) subject.getPrincipal();
        return  ((AccountDto)SecurityUtils.getSubject().getPrincipal()).getUid();
    }

    @Override
    public IDFBaseDAO<User> getDao() {
        return userDAO;
    }

     @Override
     public String add(UserParam param, AccountDto currentUser) {
        if(!isExists(UserParam.F_Username, param.getUsername())) {
            param.setSalt(RandomStringUtils.randomAlphanumeric(8));
            param.setPassword(CommonUtils.getPassword(param.getPassword(),param.getSalt()));
            param.setCode(CommonUtils.getUUID());
            param.setWorkNum(RandomStringUtils.randomNumeric(8));
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
         if (DFRequestListener.getVerifyCode().equals(paramEx.getVerifyCode())){
//             User user = this.findOne(UserParam.F_Username)
             return  RETURNCODE.UPDATE_COMPLETE.getMessage();
         }else {
             throw new BizException(ERRORCODE.VERIFIEDCODE_ILLEGAL.getCode(), ERRORCODE.VERIFIEDCODE_ILLEGAL.getMessage());
         }
     }

     @Override
     public String resetPassword(UserParam param, AccountDto currentUser) {
         User user = this.findOne(UserParam.F_ID, param.getId());
         //随机生成6位的密码
         String newPassword = RandomStringUtils.randomAlphanumeric(6);
         param.setPassword(CommonUtils.getPassword(newPassword, user.getSalt()));
         param.setLastModDate(System.currentTimeMillis());
         param.setLastModifier(currentUser.getUid());
         if (this.updateMap(param.toMap()) > 0){ //重置成功后将新密码返回
             return newPassword;
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

    @Override
    public AccountDto initUser(String userCode, String roleCode) {
        //从shiro的session给货品获取到session并进行设置
        Subject subject = SecurityUtils.getSubject();
        //得到用户信息
        AccountDto accountDto = (AccountDto) subject.getPrincipal();
        accountDto.setRoleCode(roleCode);
        Session session = subject.getSession();
        session.setAttribute("CURRENTUSER", accountDto);
        return accountDto;
    }
}