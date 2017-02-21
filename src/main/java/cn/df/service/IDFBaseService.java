package cn.df.service;


import cn.df.common.domain.BaseDomain;
import cn.df.common.service.IBaseService;
import cn.df.common.service.IPageService;
import cn.df.dao.IDFBaseDAO;

/**
 * Created by 郭旭辉 on 2016/3/13.
 */
public interface IDFBaseService<D extends IDFBaseDAO<T>, T extends BaseDomain> extends IBaseService<D, T>, IPageService<D, T> {
}
