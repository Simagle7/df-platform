package cn.df.controller.auth;

import cn.df.common.domain.BizData4Page;
import cn.df.common.utils.base.RETURNCODE;
import cn.df.common.utils.user.UserContext;
import cn.df.domain.auth.AuthModule;
import cn.df.param.auth.AuthModuleParam;
import cn.df.service.auth.IAuthModuleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Katybaby on 2017/2/22.
 * 权限模块添加
 */
@Controller
@RequestMapping(value = "/cn/df/authModule")
public class AuthModuleController {
    @Autowired
    private IAuthModuleService authModuleService;

    /**
     * 后台分页获取模块列表
     * @param param     查询参数
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return 返回，查询结果
     */
    @ResponseBody
    @RequestMapping(value="/queryPage", method = RequestMethod.POST)
//    @RequiresPermissions("module:query")
    public BizData4Page queryPage(AuthModuleParam param, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        return authModuleService.queryPage(param, pageNo, pageSize);
    }

    /**
     * 添加一个模块
     * @param param 模块参数实体
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    @RequiresPermissions("module:add")
    public String add(AuthModuleParam param){
        return authModuleService.add(param, UserContext.getCurrentUser());
    }

    /**
     * 查询模块树
     * @param status    状态，:0：正常，：停用
     * @return 返回模块树
     */
    @ResponseBody
    @RequestMapping(value = "/queryModules")
    public List queryModules(Integer status){
        return  authModuleService.queryModules(status);
    }

    /**
     * 查询模块列表（不出现子节点）
     * @param moduleFullCode    模块fullCode
     * @return 返回模块树
     */
    @ResponseBody
    @RequestMapping(value = "/queryModulesWithoutChild")
    public List queryModulesWithoutChild(String moduleFullCode){
        return  authModuleService.queryModulesNoChildren(moduleFullCode);
    }



    /**
     * 获取一个模块信息（用于修改）
     * @param id    模块id
     * @return  返回，一个模块信息
     */
    @ResponseBody
    @RequestMapping("/queryOne")
    @RequiresPermissions("module:queryOne")
    public AuthModule queryOne(@RequestParam(required = true) long id){
        return (AuthModule) authModuleService.findOne(AuthModuleParam.F_ID, id);
    }

    /**
     * 更新模块及诶单那
     * @param param    模块参数
     * @return      返回，操作码
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    @RequiresPermissions("module:update")
    public String update(AuthModuleParam param) throws Exception {
        return authModuleService.update(param, UserContext.getCurrentUser());
    }

    /**
     * 启用停用模块
     * @param id    模块id
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/disableOrEnable")
//    @RequiresPermissions("module:disableOrEnable")
    public String disableOrEnable(@RequestParam(required = true) long id){
        return authModuleService.disableOrEnable(id, UserContext.getCurrentUser());
    }

    /**
     * 删除单个模块
     * @param id    模块id
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOne")
//    @RequiresPermissions("module:delete")
    public String deleteOne(@RequestParam(required =  true) long id){
        return authModuleService.deleteOne(id);
    }

    /**
     * 批量删除
     * @param ids    模块id列表
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteByIds")
//    @RequiresPermissions("module:delete")
    public String deleteByIds(@RequestParam(required = true) Long[] ids){
        for (Long id: ids){
            authModuleService.deleteOne(id);
        }
        return RETURNCODE.DELETE_COMPLETE.getMessage();
    }

    @ResponseBody
    @RequestMapping(value = "/getModules")
    public List<AuthModule> getModules(String uid, String roleCode){
        return  authModuleService.getModules(uid, roleCode);
    }
}
