package com.qf.controller;

import com.qf.common.Result;
import com.qf.entity.Student;
import com.qf.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/add")
    @ResponseBody
    public Result add(Student student){
        return studentService.add(student);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer id){
       return studentService.delete(id);
    }

    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable Integer id, Model model){
        Student student = studentService.selectByPrimaryKey(id);
        model.addAttribute("student",student);
        return "admin-student-edit";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(Student student){
       return studentService.update(student);
    }

    @RequestMapping("/batchDelete")
    @ResponseBody
    public Result batchDelete(@RequestParam List<Integer> ids){
        return studentService.batchDelete(ids);
    }
}
