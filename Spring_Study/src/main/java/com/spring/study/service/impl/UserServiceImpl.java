package com.spring.study.service.impl;

import com.spring.study.dao.UserDao;
import com.spring.study.dao.impl.UserDaoImpl;
import com.spring.study.model.User;
import com.spring.study.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author：Haotian
 * @Date：2019/5/24 21:41
 */
@Service("myUserService")
public class UserServiceImpl implements UserService {
    /**
     * @param Service 标注此类为Service层
     * @param Autowired spring会自动注入userDao赋值
     */
    @Autowired
    private UserDao dao = new UserDaoImpl();
    @Getter
    @Setter
    private String name;

    @Override
    public void add(User user) {
        System.out.println( "Spring启动测试...." );
        System.out.println( name );
        dao.add( user );
    }
}
