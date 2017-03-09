package cn.df.controller.auth;

import cn.df.common.domain.BizData4Page;
import cn.df.common.exception.BizException;
import cn.df.common.utils.base.ERRORCODE;
import cn.df.common.utils.base.RETURNCODE;
import cn.df.common.utils.user.UserContext;
import cn.df.domain.auth.AuthOperation;
import cn.df.param.auth.AuthOperationParam;
import cn.df.service.auth.IAuthOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * Created by Katybaby on 2017/2/24.
 * 操作码
 */
@Controller
@RequestMapping(value = "/cn/df/operation")
public class AuthOperationController {

    @Autowired
    private IAuthOperationService authOperationService;


    /**
     * 分页查询操作
     * @param param         查询总数
     * @param pageNo        页码
     * @param pageSize      页大小
     * @return  返回，分页结果集
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage", method = RequestMethod.POST)
    public BizData4Page queryPage(AuthOperationParam param, @RequestParam(defaultValue = "1")Integer pageNo, @RequestParam(defaultValue = "10")Integer pageSize){
        return authOperationService.queryPage(param, pageNo, pageSize);
    }


    /**
     * 添加一个操作
     * @param param     添加参数
     * @return  返回，操作吗
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(AuthOperationParam param){
        return authOperationService.add(param, UserContext.getCurrentUser());
    }

    /**
     * 根据操作id查询一个操作（用于更新）
     * @param id        操作id
     * @return  返回，操作信息实体
     */
    @ResponseBody
    @RequestMapping(value = "/queryOne")
    public AuthOperation queryOne(long id){
        return (AuthOperation) authOperationService.findOne(AuthOperationParam.F_ID, id);
    }

    /**
     * 更新操作
     * @param param 更新参数
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(AuthOperationParam param){
        return authOperationService.update(param, UserContext.getCurrentUser());
    }

    /**
     * 启用、停用功能
     * @param id    功能id
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/disableOrEnable")
    public String disableOrEnable(@RequestParam(required = true) long id){
        return authOperationService.disableOrEnable(id, UserContext.getCurrentUser());
    }

    /**
     * 删除一个功能
     * @param id        功能id
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOne")
    public  String deleteOne(Long id){
        if(authOperationService.deleteById(id) > 0){
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    /**
     * 批量删除
     * @param ids   id列表
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteByIds")
    public String deleteByIds(Long[] ids){
        if(authOperationService.deleteByIds(Arrays.asList(ids)) > 0){
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }
}
