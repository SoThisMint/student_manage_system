package com.qf.mapper;

import com.qf.dao.IBaseDao;
import com.qf.entity.Student;

public interface StudentMapper extends IBaseDao<Student> {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}