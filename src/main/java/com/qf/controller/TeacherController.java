package com.qf.controller;

import com.qf.common.Result;
import com.qf.entity.Teacher;
import com.qf.mapper.TeacherMapper;
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

    @RequestMapping("/add")
    @ResponseBody
    public Result add(Teacher teacher){
        Result result = new Result();
        int res = teacherService.insertSelective(teacher);
        if(res>0){
            result.setData("添加成功！");
            result.setResult(true);
        }else{
            result.setResult(false);
            result.setData("添加失败！");
        }
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer id){
        Result result = new Result();
        int res = teacherService.deleteByPrimaryKey(id);
        if(res>0){
            result.setData("删除成功！");
            result.setResult(true);
        }else{
            result.setResult(false);
            result.setData("删除失败！");
        }
        return result;
    }

    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable Integer id,Model model){
        Teacher teacher = teacherService.selectByPrimaryKey(id);
        model.addAttribute("teacher",teacher);
        return "admin-teacher-edit";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(Teacher teacher){
        Result result = new Result();
        int res = teacherService.updateByPrimaryKeySelective(teacher);
        if(res>0){
            result.setData("修改成功！");
            result.setResult(true);
        }else{
            result.setResult(false);
            result.setData("修改失败！");
        }
        return result;
    }

    @RequestMapping("/batchDelete")
    @ResponseBody
    public Result batchDelete(@RequestParam List<Integer> ids){
        Result result = new Result();
        int res = teacherService.batchDeleteByIds(ids);
        if(res>0){
            result.setData("批量删除成功！");
            result.setResult(true);
        }else{
            result.setResult(false);
            result.setData("批量删除失败！");
        }
        return result;
    }

}
