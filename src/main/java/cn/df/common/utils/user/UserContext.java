package cn.df.common.utils.user;


import cn.df.common.dto.user.AccountDto;
import cn.df.common.exception.BizException;
import cn.df.common.listener.DFRequestListener;
import cn.df.common.utils.base.ERRORCODE;
import cn.df.domain.user.User;
import org.apache.shiro.SecurityUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Katybaby.
 * 用户上下文
 */
public class UserContext {

//    private  static  ThreadLocal<AccountDto> context = new ThreadLocal<>();


//    public static void initUser(){
//        HttpServletRequest request = CMRequestFilter.getRequest();
//        String url = request.getRequestURI();
//        if (url.contains("login")){
//
//        }
//        //获取access_token
//        Cookie cookie = HttpUtils.getCookie(request.getCookies(),HttpUtils.ACCESS_TOKEN);
//        String token = cookie.getValue();
//        UserDetail userDetail = (UserDetail) request.getSession().getAttribute(token);
//        if (userDetail != null){
//            AccountDto accountDto = setAccount(userDetail);
//            IUserContext userContext = new DefaultUserContextImpl();
//            Map<String, Object> datas = new HashMap<>(4);
//            datas.put(IUserContext.UID, accountDto.getUid());
//            ((DefaultUserContextImpl) userContext).setContexts(datas);
//            UserContextHolder.setUserContext(userContext);
//        }
//        setCurrentUser(setAccount(userDetail));
//    }AccountDto

    /**
     * 更新当前用户
     * @return
     */
    public static AccountDto refreshUser(){
        return null;
    }

    /**
     * 获取当前用户
     * @return 返回 AccountDto
     */
    public static AccountDto getCurrentUser(){
        HttpServletRequest request = DFRequestListener.getRequest();
        //获取access_token
//        Cookie cookie = HttpUtils.getCookie(request.getCookies(),HttpUtils.ACCESS_TOKEN);
//        if (cookie != null){
//            String token = cookie.getValue();
            AccountDto accountDto = (AccountDto) SecurityUtils.getSubject().getSession().getAttribute("CURRENTUSER");
//            UserDetail userDetail = (UserDetail) request.getSession().getAttribute(token);
            if (accountDto != null){
                return accountDto;
            }else {
                throw new BizException(ERRORCODE.ILLEGAL_LOGIN.getCode(), ERRORCODE.ILLEGAL_LOGIN.getMessage());
            }
//        }else {
//            throw new BizException(ERRORCODE.ILLEGAL_LOGIN.getCode(), ERRORCODE.ILLEGAL_LOGIN.getMessage());
//        }

    }

    /**
     * 设置当前用户
     * @param user
     */
//    public static void setCurrentUser(AccountDto user){
//        //缓存记录
//        context.set(user);
//    }

    /**
     * 移除当前用户
     */
//    public static void removeCurrentUser(){
//        context.remove();
//    }

    private static AccountDto setAccount(User user){
        AccountDto accountDto = new AccountDto();
        accountDto.setUid(user.getCode());
        accountDto.setUsername(user.getUsername());
        accountDto.setPassword(user.getPassword());
        return accountDto;
    }
}
