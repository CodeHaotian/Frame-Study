package com.spring.study.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Haotian
 * @Date: 2019/12/5 14:15
 * @Description: 前后端交互
 */
@RestController
public class UserController {

    @RequestMapping("/save")
    public String save() {
        return "Hello Spring MVC";
    }
}
