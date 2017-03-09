package cn.df.common.listener;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Katybaby on 2017/2/21.
 *
 */
public class DFRequestListener extends RequestContextListener {

    public static HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取验证码
     * @return  返回，验证码
     */
    public static String getVerifyCode(){
        return String.valueOf(getRequest().getSession().getAttribute("VERIFYCODE"));
    }
}
