package com.qf.service.impl;

import com.qf.dao.IBaseDao;
import com.qf.service.IBaseService;

import java.util.List;

/**
 * @author ：Tony
 * @date ：Created in 2019/4/2 19:00
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    public abstract IBaseDao<T> getBaseDao();

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return getBaseDao().deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T t) {
        return getBaseDao().insert(t);
    }

    @Override
    public int insertSelective(T t) {
        return getBaseDao().insertSelective(t);
    }

    @Override
    public T selectByPrimaryKey(Integer id) {
        return getBaseDao().selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return getBaseDao().updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return getBaseDao().updateByPrimaryKey(t);
    }

    @Override
    public List<T> getList() {
        return getBaseDao().getList();
    }
}
