package com.spring.study.dao;

import com.spring.study.model.User;

import java.util.List;

/**
 * @Author：Haotian
 * @Date：2019/5/25 16:25
 */
public interface UserDao {
    /**
     * 添加用户
     * @param user 用户
     */
    void add(User user);

}
