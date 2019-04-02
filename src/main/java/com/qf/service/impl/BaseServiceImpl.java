package com.qf.service.impl;

import com.qf.common.Result;
import com.qf.dao.IBaseDao;
import com.qf.entity.Student;
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

    @Override
    public Result add(T t) {
        Result result = new Result();
        int res = getBaseDao().insertSelective(t);
        if(res>0){
            result.setData("添加成功！");
            result.setResult(true);
        }else{
            result.setResult(false);
            result.setData("添加失败！");
        }
        return result;
    }

    @Override
    public Result delete(Integer id) {
        Result result = new Result();
        int res = getBaseDao().deleteByPrimaryKey(id);
        if(res>0){
            result.setData("删除成功！");
            result.setResult(true);
        }else{
            result.setResult(false);
            result.setData("删除失败！");
        }
        return result;
    }

    @Override
    public Result update(T t) {
        Result result = new Result();
        int res = getBaseDao().updateByPrimaryKeySelective(t);
        if(res>0){
            result.setData("修改成功！");
            result.setResult(true);
        }else{
            result.setResult(false);
            result.setData("修改失败！");
        }
        return result;
    }

    @Override
    public Result batchDelete(List<Integer> ids) {
        Result result = new Result();
        int res = getBaseDao().batchDelete(ids);
        if(res>0){
            result.setData("批量删除成功！");
            result.setResult(true);
        }else{
            result.setResult(false);
            result.setData("批量删除失败！");
        }
        return result;
    }
}
