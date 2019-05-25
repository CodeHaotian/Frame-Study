package com.spring.study.dao.impl;

import com.spring.study.dao.UserDao;
import com.spring.study.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author：Haotian
 * @Date：2019/5/25 16:26
 * Repository 标注此类为Dao层
 * PostConstruct 相当于init-method=""
 * PreDestroy 相当于destroy-method=""
 */
@Repository
public class UserDaoImpl implements UserDao {
    @PostConstruct
    public void myInit() {
        System.out.println( "UserDaoImpl自定义的初始化方法..." );
    }

    @PreDestroy
    public void myDestroy() {
        System.out.println( "UserDaoImpl自定义的销毁方法..." );
    }

    @Override
    public void add(User user) {
        System.out.println( "添加用户" + user );
    }
}
