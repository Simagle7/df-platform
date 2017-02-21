package cn.df.common.utils.user;

/**
 * Created by Katybaby
 */
public class UserContextHolder {
    private static ThreadLocal<IUserContext> userContextThreadLocal = new ThreadLocal<>();

    public static void setUserContext(IUserContext userContext){
        userContextThreadLocal.set(userContext);
    }

    public static IUserContext getUserContext(){
        return userContextThreadLocal.get();
    }
}
