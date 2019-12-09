package com.spring.demo.controller;

import com.spring.demo.domain.Role;
import com.spring.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/9 9:50
 * @Description: 角色数据前后端交互
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        modelAndView.addObject( "roleList", roleList );
        modelAndView.setViewName( "role-list" );
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role) {
        roleService.save( role );
        return "redirect:/role/list";
    }

    @RequestMapping("/delete/{roleId}")
    public String delete(@PathVariable("roleId") Long roleId) {
        //根据id删除角色
        roleService.delete( roleId );
        return "redirect:/role/list";
    }


}
