package com.spring.demo.controller;

import com.spring.demo.domain.Role;
import com.spring.demo.domain.User;
import com.spring.demo.service.RoleService;
import com.spring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/9 15:43
 * @Description: 用户数据前后端交互
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userService.list();
        modelAndView.addObject( "userList", userList );
        modelAndView.setViewName( "user-list" );
        return modelAndView;
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session) {
        User user = userService.login( username, password );
        if (user != null) {
            //登录成功  将user存储到session
            session.setAttribute( "user", user );
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }

    @RequestMapping("/saveUI")
    public ModelAndView saveUI() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        modelAndView.addObject( "roleList", roleList );
        modelAndView.setViewName( "user-add" );
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(User user, Long[] roleIds) {
        //保存用户数据，和对应的角色权限
        userService.save( user, roleIds );
        //跳转到用户数据展示页面
        return "redirect:/user/list";
    }

    @RequestMapping("/delete/{userId}")
    public String delete(@PathVariable("userId") Long userId) {
        //根据id删除用户
        userService.delete( userId );
        //跳转到用户数据展示页面
        return "redirect:/user/list";
    }
}
