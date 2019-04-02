package com.qf.controller;

import com.qf.entity.Teacher;
import com.qf.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    public String login(Teacher teacher, Model model){
        Teacher t = teacherService.login(teacher);
        if(t!=null){
            List<Teacher> teacherList = teacherService.getList();
            model.addAttribute("teacherList",teacherList);
            model.addAttribute("teacher",t);
            return "teacherList";
        }
        return "teacherLogin";
    }

}
