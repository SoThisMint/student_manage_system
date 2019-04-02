package com.qf.mapper;

import com.qf.dao.IBaseDao;
import com.qf.entity.Teacher;

public interface TeacherMapper extends IBaseDao<Teacher> {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}