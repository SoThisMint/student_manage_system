package com.qf.service;

import com.qf.common.Result;
import com.qf.entity.Student;

import java.util.List;

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

    List<T> getList();

    Result add(T t);

    Result delete(Integer id);

    Result update(T t);

    Result batchDelete(List<Integer> ids);
}
