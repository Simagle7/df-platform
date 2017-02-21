package cn.df.common.utils.user;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Katybaby
 * 用户上下文默认实现类
 */
public class DefaultUserContextImpl implements IUserContext {
    protected Map<String, Object> contexts = new HashMap<>();

    /**
     * 设置上下文
     * @return
     */
    public void setContexts(Map<String, Object> contexts){
        this.contexts = contexts;
    }
    @Override
    public Map<String, Object> getContext() {
        return null;
    }
}
