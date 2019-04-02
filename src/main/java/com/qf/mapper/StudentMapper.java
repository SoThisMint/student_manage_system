package com.qf.mapper;

import com.qf.dao.IBaseDao;
import com.qf.entity.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper extends IBaseDao<Student> {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Student getStudentByNameAndPassword(@Param("sName") String sName, @Param("sPassword") String sPassword);
}