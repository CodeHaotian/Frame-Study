package com.ssm.study.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssm.study.entity.Girl;
import com.ssm.study.model.Code;
import com.ssm.study.model.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Haotian
 * @Date: 2019/12/13 20:32
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @RequestMapping("/findAll")
    @ResponseBody
    public Msg findAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize,@RequestParam(required = false) String username) {
        Page<Girl> page = PageHelper.startPage( pageNum, pageSize ).doSelectPage( () -> userService.findAll(username) );
        msg.set( Code.SUCCESS, "查询成功", page.getTotal(), page.getResult() );
        System.out.println( msg );
        return msg;
    }
}