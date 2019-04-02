package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/login")
    public String login(){
        return "index";
    }
}
