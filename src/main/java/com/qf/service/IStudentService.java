package com.qf.service;

import com.qf.entity.Student;

/**
 * @author ：Tony
 * @date ：Created in 2019/4/2 18:58
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public interface IStudentService extends IBaseService<Student> {
    Student login(Student student);
}
