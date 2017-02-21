package cn.df.common.utils.user;

import java.util.Map;

/**
 * Created by Katybaby
 * 获取业务上下文接口，需要业务方实现
 */
public interface IUserContext {
    public static  final String UID = "uid";

    public Map<String, Object> getContext();
}
