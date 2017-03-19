package cn.df.controller.auth;

import cn.df.common.domain.BizData4Page;
import cn.df.common.utils.user.UserContext;
import cn.df.domain.user.User;
import cn.df.param.user.UserParam;
import cn.df.service.auth.IAuthUserRoleService;
import cn.df.service.user.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by katybaby on 2017/2/22.
 * 用户角色授权控制表
 */
@Controller
@RequestMapping(value = "/cn/df/authRoleUser")
public class AuthRoleUserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IAuthUserRoleService authUserRoleService;

//    @Autowired
//    private DfRealm dfRealm;

    /**
     * 查询用户
     * @param param     查询参数
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return 返回，用户分页
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage")
//    @RequiresPermissions("userRole:query")
    public BizData4Page queryPage(UserParam param, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        return userService.queryPage(param, pageNo, pageSize);
    }

    /**
     * 查询单个用户
     * @param uid 用户uid
     * @return 返回，用户信息
     */
    @ResponseBody
    @RequestMapping(value = "/getUserInfoByUid")
//    @RequiresPermissions("userRole:setRole")
    public User getUserInfoByUid(String uid){
        return (User) userService.findOne(UserParam.F_Code, uid);
    }

    /**
     * 查询所有角色和当前身份用户具有的角色
     * @param uid           用户uid
     * @param isNeedDefault 结果集是否需要默认角色
     * @return  返回，角色列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryRolesForAuth")
//    @RequiresPermissions("userRole:setRole")
    public Map<String, Object> queryRolesForAuth(@RequestParam(required = true) String uid, @RequestParam(defaultValue = "false") Boolean isNeedDefault){
        return  authUserRoleService.queryRolesForAuth(uid, isNeedDefault);
    }

    /**
     * 保存用户角色关系
     * @param uid           用户uid
     * @param roleCodes     角色代码列表
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("userRole:setRole")
    public String save(@RequestParam(required = true) String uid, @RequestParam(required = true) String[] roleCodes){
        return authUserRoleService.save(uid,  roleCodes, UserContext.getCurrentUser());
    }

    /**
     * 更新用户权限缓存
     * @return 返回，操作码
     */
//    @ResponseBody
//    @RequestMapping(value = "/refreshCache")
//    @RequiresPermissions("userRole:refreshCache")
//    public String refreshCache(){
//        dfRealm.clearCahced();
//        return RETURNCODE.SUCCESS_COMPLETE.getMessage();
//    }

}
