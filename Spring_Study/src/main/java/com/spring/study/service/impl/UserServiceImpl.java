package com.spring.study.service.impl;

import com.spring.study.service.UserService;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author：Haotian
 * @Date：2019/5/24 21:41
 */
public class UserServiceImpl implements UserService {
    @Getter
    @Setter
    private String name;

    @Override
    public void add() {
        System.out.println( "Spring启动测试...." );
        System.out.println( name );
    }
}
