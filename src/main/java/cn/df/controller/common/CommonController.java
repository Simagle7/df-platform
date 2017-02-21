package cn.df.controller.common;

import cn.df.common.exception.BizException;
import cn.df.common.utils.base.ERRORCODE;
import cn.df.common.utils.sys.VerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 郭旭辉 on 2017/2/21.
 * 通用控制类
 */
@Controller
@RequestMapping(value = "/cm/df/common")
public class CommonController {

    /**
     * 获取图片验证码
     * @param request      请求流
     * @param response     相应流
     */
    @RequestMapping(value = "/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/png");

        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入会话session
        HttpSession session = request.getSession(true);
        //删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase());
        //生成图片
        int w = 100, h = 30;
        try {
            VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
        } catch (IOException e) {
            throw new BizException(ERRORCODE.GET_VERIFYCODE_FAILED.getCode(), ERRORCODE.GET_VERIFYCODE_FAILED.getMessage());
        }
    }
}
