package com.spring.study.web.action;

import com.spring.study.model.Users;
import com.spring.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @Author：Haotian
 * @Date：2019/5/25 16:57
 */
@Controller
public class UserAction {
    /**
     * @param Controller 标注此类为Action层
     * @param Autowired spring自动注入userService赋值
     * @param Qualifier 根据指定的id注入属性
     */
    @Autowired
    @Qualifier("userService")
    private UserService service;

    public void save(Users u) {
        System.out.println( "执行action save方法 " );
        service.add( u );
        service.delete();
    }
}
