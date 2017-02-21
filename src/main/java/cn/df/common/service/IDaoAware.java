package cn.df.common.service;


import cn.df.common.dao.IBaseDAO;
import cn.df.common.domain.BaseDomain;

/**
 * Created by 郭旭辉 on 2016/3/13.
 * 业务主对象DAO注入
 */
/*
    @authot simagle
*/
public interface IDaoAware<D extends IBaseDAO, T extends BaseDomain> {
    public D getDao();
}
