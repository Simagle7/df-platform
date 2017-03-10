package cn.df.controller.auth;

import cn.df.service.auth.IAuthAclService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
/**
 * Created by Katybaby on 2017/3/10.
 * 权限Acl 控制类
 */
@Controller
@RequestMapping(value =  "/cn/df/authAcl")
public class AuthAclController {

    @Autowired
    private IAuthAclService authAclService;


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
}
