package com.qf.service;

/**
 * @author ：Tony
 * @date ：Created in 2019/4/2 18:59
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public interface IBaseService<T> {
    int deleteByPrimaryKey(Integer id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

}
