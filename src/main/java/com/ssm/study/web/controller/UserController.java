package com.ssm.study.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ssm.study.entity.Girl;
import com.ssm.study.model.Code;
import com.ssm.study.model.Msg;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Haotian
 * @version 1.0.0
 * @date 2020/7/23 8:59
 **/
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @RequestMapping("/findAll")
    public Msg findAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(required = false) String username) {
        // 使用 PageHelper 提供的lambda方式进行分页
        Page<Girl> page = PageHelper.startPage( pageNum, pageSize ).doSelectPage( () -> userService.findAll( username ) );
        msg.set( Code.SUCCESS, "查询成功", page.getTotal(), page.getResult() );
        return msg;
    }
}