package cn.df.controller.user;

import cn.df.common.domain.BizData4Page;
import cn.df.common.dto.user.AccountDto;
import cn.df.common.exception.BizException;
import cn.df.common.utils.base.ERRORCODE;
import cn.df.common.utils.base.RETURNCODE;
import cn.df.common.utils.user.UserContext;
import cn.df.domain.user.User;
import cn.df.param.user.UserParam;
import cn.df.param.user.UserParamEx;
import cn.df.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * Created by Katybaby on 2017/2/21.
 */
@Controller
    @RequestMapping(value = "/cn/df/user")
public class UserController {

    @Autowired
    private IUserService userService;


    /**
     * 用户登入
     * @param request       请求流
     * @param response      响应流
     * @return  返回，用户信息实体
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String isLogin(HttpServletRequest request, HttpServletResponse response) {
        return userService.isLogin(request, response);
    }

    /**
     * 初始化用户信息
     * @param userCode  用户代码
     * @param roleCode  角色代码
     * @return  返回，用户信息实体
     */
    @ResponseBody
    @RequestMapping(value = "/initUser", method = RequestMethod.POST)
    public AccountDto intUser(String userCode, String roleCode){
        return userService.initUser(userCode, roleCode);
    }
    /**
     * 分页查询
     * @param param     查询参数
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return  分页结果
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage", method = RequestMethod.POST)
    public BizData4Page queryPage(UserParam param, @RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "2") Integer pageSize){
        return userService.queryPage(param, pageNo, pageSize);
    }

    /**
     * 添加一个用户
     * @param param 用户信息
     * @return 返回，操作码   
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(UserParam param){
        return userService.add(param, UserContext.getCurrentUser());
    }

    /**
     * 查找一个用户
     * @param id    用户id
     * @return 返回，用户信息实体
     */
    @ResponseBody
    @RequestMapping(value = "/queryOne")
    public User queryOne(long id){
        return (User) userService.findOne(UserParam.F_ID, id);
    }

    /**
     * 更新一个用户
     * @param param 用户信息
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public String update(UserParam param){
        return userService.update(param, UserContext.getCurrentUser());
    }

    /**
     * 忘记密码
     * @param paramEx   用户信息
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/forgetPassword")
    public String forgetPassword(UserParamEx paramEx){
        return userService.forgetPassword(paramEx, UserContext.getCurrentUser());
    }

    /**
     * 重置密码
     * @param param 重置参数
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/resetPassword")
    public String resetPassword(UserParam param){
        return userService.resetPassword(param, UserContext.getCurrentUser());
    }

    /**
     * 停用、启用用户
     * @param param     参数
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/disabledOrEnabled", method = RequestMethod.POST)
    public String disabledOrEnabled(UserParam param){
        return userService.disabledOrEnabled(param, UserContext.getCurrentUser());
    }

    /**
     * 删除一个用户
     * @param id    用户id
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(Long id){
        if (userService.deleteById(id) > 0){
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getMessage(), ERRORCODE.OPERATION_FAIL.getCode());
    }

    /**
     * 批量删除用户
     * @param ids 用户id列表
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteByIds")
    public String deleteByIds(Long[] ids){
        if (userService.deleteByIds(Arrays.asList(ids)) != 0) {
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        } else {
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
    }

}
