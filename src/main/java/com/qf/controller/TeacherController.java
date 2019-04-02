package com.qf.controller;

import com.qf.common.Result;
import com.qf.entity.Teacher;
import com.qf.service.ITeacherService;
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
    public String login(Teacher teacher, Model model) {
        Teacher t = teacherService.login(teacher);
        if (t != null) {
            List<Teacher> teacherList = teacherService.getList();
            model.addAttribute("teacherList", teacherList);
            model.addAttribute("teacher", t);
            return "teacherList";
        }
        return "teacherLogin";
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result add(Teacher teacher) {
        return teacherService.add(teacher);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer id) {
        return teacherService.delete(id);
    }

    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable Integer id, Model model) {
        Teacher teacher = teacherService.selectByPrimaryKey(id);
        model.addAttribute("teacher", teacher);
        return "admin-teacher-edit";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(Teacher teacher) {
        return teacherService.update(teacher);
    }

    @RequestMapping("/batchDelete")
    @ResponseBody
    public Result batchDelete(@RequestParam List<Integer> ids) {
        return teacherService.batchDelete(ids);
    }

}
