package cn.df.service;


import cn.df.common.domain.BaseDomain;
import cn.df.common.service.impl.AbstractPageService;
import cn.df.dao.IDFBaseDAO;

/**
 * Created by 郭旭辉 on 2016/3/13.
 */

public abstract class AbstractDFService<D extends IDFBaseDAO,T extends BaseDomain> extends AbstractPageService<D, T> {

}
