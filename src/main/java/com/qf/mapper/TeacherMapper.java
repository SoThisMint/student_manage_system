package com.qf.mapper;

import com.qf.dao.IBaseDao;
import com.qf.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper extends IBaseDao<Teacher> {
    Teacher getTeacherByNameAndPassword(@Param("tName") String tName,@Param("tPassword") String tPassword);

    int batchDeleteByIds(List<Integer> ids);
}