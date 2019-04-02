package com.qf.service.impl;

import com.qf.dao.IBaseDao;
import com.qf.entity.Student;
import com.qf.mapper.StudentMapper;
import com.qf.service.IStudentService;
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
public class StudentServiceImpl extends BaseServiceImpl<Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public IBaseDao<Student> getBaseDao() {
        return studentMapper;
    }

    @Override
    public Student login(Student student) {
        return studentMapper.getStudentByNameAndPassword(student.getsName(),student.getsPassword());
    }
}
