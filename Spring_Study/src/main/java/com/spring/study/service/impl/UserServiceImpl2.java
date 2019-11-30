package com.spring.study.service.impl;

import com.spring.study.model.Users;
import com.spring.study.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * @Author：Haotian
 * @Date：2019/5/24 21:41
 */
@Service("myUserService")
public class UserServiceImpl2 implements UserService {
    /**
     * @param Service 标注此类为Service层
     * @param Autowired spring会自动注入userDao赋值
     */
    @Getter
    @Setter
    private String name;

    @Override
    public void add(Users user) {
        System.out.println( "Spring启动测试...." );
        System.out.println( name );
    }

    @Override
    public void delete() {
        System.out.println( "删除用户..." );
    }
}
