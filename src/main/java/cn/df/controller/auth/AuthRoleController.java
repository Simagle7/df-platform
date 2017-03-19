package cn.df.controller.auth;


import cn.df.common.domain.BizData4Page;
import cn.df.common.utils.user.UserContext;
import cn.df.domain.auth.AuthRole;
import cn.df.param.auth.AuthRoleParam;
import cn.df.service.auth.IAuthAclService;
import cn.df.service.auth.IAuthRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * Created by KatyByby on 2016/8/15.
 * 权限角色控制类
 */
@Controller
@RequestMapping(value = "/cn/df/authRole")
public class AuthRoleController {

    @Autowired
    private IAuthRoleService authRoleService;
    @Autowired
    private IAuthAclService authAclService;


    /**
     * 分页查询角色
     * @param authRoleParam     查询参数
     * @param pageNo            页码
     * @param pageSize          页大小
     * @return  返回，分页结果
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage", method = RequestMethod.POST)
//    @RequiresPermissions("authRole:query")
    public BizData4Page queryPage(AuthRoleParam authRoleParam, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        return authRoleService.queryPage(authRoleParam, pageNo, pageSize);
    }

    /**
     * 添加角色
     * @param param  角色参数
     * @return 返回，操作码
     */
    @ResponseBody
//    @RequiresPermissions("authRole:add")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(AuthRoleParam param){
        return  authRoleService.add(param, UserContext.getCurrentUser());
    }



    /**
     * 查询一个角色信息（用于修改）
     * @param id    角色id
     * @return 返回，一个角色实体信息
     */
    @ResponseBody
    @RequestMapping(value = "/queryOne")
//    @RequiresPermissions("authRole:query")
    public AuthRole queryOne(long id){
        return (AuthRole) authRoleService.findOne(AuthRoleParam.F_ID, id);
    }

    /**
     * 更新角色
     * @param param  角色实体
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    @RequiresPermissions("authRole:update")
    public String update(AuthRoleParam param){
        return authRoleService.update(param, UserContext.getCurrentUser());
    }

    /**
     * 启用，停用角色
     * @param param  更新参数
     * @return 返回操作码
     */
    @ResponseBody
    @RequestMapping(value = "/disableOrEnable")
//    @RequiresPermissions("authRole:disableOrEnable")
    public String disableOrEnable(AuthRoleParam param){
        return authRoleService.disableOrEnable(param, UserContext.getCurrentUser());
    }

    /**
     * 单个删除
     * @param id        角色id
     * @param roleCode  角色代码
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOne")
//    @RequiresPermissions("authRole:delete")
    public String deleteOne(Long id, String roleCode){
        return authRoleService.deleteOne(id, roleCode);
    }

    /**
     * 批量删除
     * @param ids           角色id集合
     * @param roleCodes     角色code集合
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "deleteByIds")
//    @RequiresPermissions("authRole:delete")
    public String deleteByIds(Long[] ids, String[] roleCodes){
        return authRoleService.deleteByIds(Arrays.asList(ids), Arrays.asList(roleCodes));
    }

    /**
     * 获取已现则的模块以及操作
     * @param subjectType   主体类型，0：角色
     * @param roleCode      角色code
     * @return 返回，模块和操作列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryAuthAcl")
//    @RequiresPermissions("authRole:queryAuth")
    public List queryAuthAcl(Integer subjectType, String roleCode){
        return authAclService.queryResourceCode(subjectType, roleCode);
    }

    /**
     * 查询模块操作树
     * @return  返回， 模块操作树列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryModuleAndOperation")
    public List queryModuleAndOperation(){
        return authRoleService.queryModuleAndOperation();
    }

    /**
     * 保存权限
     * @param roleCode          用户代码
     * @param moduleCodes       模块代码集合
     * @param operationCodes    操作代码集合
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/saveAuth")
//    @RequiresPermissions("authRole:saveAuth")
    public String saveAuth(String roleCode, String[] moduleCodes, String[] operationCodes){
        return authRoleService.saveAuth(roleCode, moduleCodes, operationCodes,UserContext.getCurrentUser());
    }

    /**
     * 根据用户uid查询用户角色组
     * @param userCode      用户代码
     * @return  返回，用户角色列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryRoles4User")
    public List queryRoles4User(String userCode){
        return authRoleService.queryRoles4User(userCode);
    }

    @ResponseBody
    @RequestMapping(value = "/queryRolesForAuth")
    public Map<String, Object> queryRolesForAuth(){
        return null;
    }
}
