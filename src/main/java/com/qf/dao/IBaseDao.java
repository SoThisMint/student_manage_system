package com.qf.dao;

import java.util.List;

/**
 * @author ：Tony
 * @date ：Created in 2019/4/2 18:57
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public interface IBaseDao<T> {
    int deleteByPrimaryKey(Integer id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

    List<T> getList();

    int batchDelete(List<Integer> ids);
}
