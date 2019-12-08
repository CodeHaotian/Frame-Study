package com.spring.study.web.controller;


import com.spring.study.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Haotian
 * @Date: 2019/12/6 14:03
 * @Description: 注入父类
 */
public class BaseController {
    @Autowired
    protected GirlService girlService;
}
