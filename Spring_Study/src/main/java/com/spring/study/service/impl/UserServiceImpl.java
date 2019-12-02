package com.spring.study.service.impl;

import com.spring.study.model.Users;
import com.spring.study.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author：Haotian
 * @Date：2019/5/24 21:41
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public void add(Users user) {
        System.out.println( "添加用户" + user );
    }

    @Override
    public void delete() {
        System.out.println( "删除用户..." );
    }

    @Override
    public String test(String name) {
        return null;
    }
}
