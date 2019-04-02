package com.qf.controller;

import com.qf.entity.Teacher;
import com.qf.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：Tony
 * @date ：Created in 2019/4/2 17:52
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;

    @RequestMapping("/login")
    public String login(Teacher teacher){
        boolean res = teacherService.login(teacher);
        if(res){
            return "index2";
        }
        return "login";
    }

}
