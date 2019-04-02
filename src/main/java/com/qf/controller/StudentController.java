package com.qf.controller;

import com.qf.entity.Student;
import com.qf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author ：Tony
 * @date ：Created in 2019/4/2 17:40
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping("/login")
    public String login(Student student, Model model){
        Student s = studentService.login(student);
        if(s!=null){
            List<Student> studentList = studentService.getList();
            model.addAttribute("student",s);
            model.addAttribute("studentList",studentList);
            return "studentList";
        }
        return "studentLogin";
    }
}
