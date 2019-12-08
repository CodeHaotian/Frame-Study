package com.spring.study.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: Haotian
 * @Date: 2019/12/6 9:37
 * @Description: 返回页面
 */
@Controller
public class DemoController {

    @RequestMapping("/demo")
    public ModelAndView demo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject( "name" );
        modelAndView.setViewName( "/demo" );
        return modelAndView;
    }

}
