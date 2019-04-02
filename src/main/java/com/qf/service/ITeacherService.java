package com.qf.service;

import com.qf.entity.Teacher;

import java.util.List;

/**
 * @author ：Tony
 * @date ：Created in 2019/4/2 18:58
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public interface ITeacherService extends IBaseService<Teacher> {
    Teacher login(Teacher teacher);

    int batchDeleteByIds(List<Integer> ids);
}
