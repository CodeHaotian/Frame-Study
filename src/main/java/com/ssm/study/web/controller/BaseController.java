package com.ssm.study.web.controller;

import com.ssm.study.model.Msg;
import com.ssm.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Haotian
 * @Date: 2019/12/13 21:11
 */
public class BaseController {
    @Autowired
    protected UserService userService;
    @Autowired
    protected Msg msg;
}
