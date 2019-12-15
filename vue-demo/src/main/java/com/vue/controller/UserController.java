package com.vue.controller;

import com.vue.entity.Girl;
import com.vue.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/15 19:00
 * @Description: 前后端数据接口
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<Girl> findAll() {
        return userService.findAll();
    }

    @RequestMapping("/findById")
    public Girl findById(Integer id) {
        return userService.findById( id );
    }

    @RequestMapping("/update")
    public void update(@RequestBody Girl girl) {
        log.info( "gril：{}", girl );
        userService.update( girl );
    }
}
