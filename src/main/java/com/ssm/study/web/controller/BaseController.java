package com.ssm.study.web.controller;

import com.ssm.study.model.Msg;
import com.ssm.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Haotian
 * @version 1.0.0
 * @date 2020/7/23 8:59
 **/
public class BaseController {
    @Autowired
    protected UserService userService;
    @Autowired
    protected Msg msg;
}
