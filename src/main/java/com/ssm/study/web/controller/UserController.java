package com.ssm.study.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author：Haotian
 * @Date：2019/5/29 22:27
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/list")
    public String list(){
        return "user/userlist";
    }
}
