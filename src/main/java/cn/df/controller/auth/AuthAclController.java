package cn.df.controller.auth;

import cn.df.common.shiro.DfRealm;
import cn.df.common.utils.base.RETURNCODE;
import cn.df.service.auth.IAuthAclService;
import cn.df.service.auth.IAuthOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Katybaby on 2017/3/10.
 * 权限Acl 控制类
 */
@Controller
@RequestMapping(value =  "/cn/df/authAcl")
public class AuthAclController {

    @Autowired
    private IAuthAclService authAclService;
    @Autowired
    private IAuthOperationService authOperationService;
    @Autowired
    private DfRealm dfRealm;


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

    @ResponseBody
    @RequestMapping(value = "/getPermissions")
    public List<String> getPermissions(String uid, String roleCode){
        List<String> result = new ArrayList<>();
        Map<String, List<String>> authCodeListMap = authOperationService.getOperation(uid, roleCode);
        for(Map.Entry<String, List<String>> entry : authCodeListMap.entrySet()){
            String moduleUrl = entry.getKey();
            if(!moduleUrl.endsWith("/")){
                moduleUrl += "/";
            }
            for(String authCode: entry.getValue()){
                result.add(moduleUrl+authCode);
            }
        }
        return  result;
    }

    /**
     * 更新用户权限缓存
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/refreshCache")
//    @RequiresPermissions("userRole:refreshCache")
    public String refreshCache(){
        dfRealm.clearCahced();
        return RETURNCODE.SUCCESS_COMPLETE.getMessage();
    }
}
