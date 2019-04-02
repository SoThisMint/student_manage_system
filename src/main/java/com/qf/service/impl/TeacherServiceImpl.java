package com.qf.service.impl;

import com.qf.dao.IBaseDao;
import com.qf.entity.Teacher;
import com.qf.mapper.TeacherMapper;
import com.qf.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：Tony
 * @date ：Created in 2019/4/2 18:59
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Service
public class TeacherServiceImpl extends BaseServiceImpl<Teacher> implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public IBaseDao<Teacher> getBaseDao() {
        return teacherMapper;
    }

    @Override
    public boolean login(Teacher teacher) {
        Teacher t = teacherMapper.selectByPrimaryKey(teacher.getId());
        if(t!=null&&t.gettName().equals(teacher.gettName())){
            return true;
        }
        return false;
    }
}
