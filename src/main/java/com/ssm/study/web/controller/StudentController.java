package com.ssm.study.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author：Haotian
 * @Date：2019/5/30 20:40
 */
@Controller
@RequestMapping("/stu")
public class StudentController {

    @RequestMapping("/test1")
    public String test1() {
        //不同控制器转发
        //return "forward:/user/list.do";
        //不同控制器重定向
        return "redirect:/user/list.do";
    }
}
