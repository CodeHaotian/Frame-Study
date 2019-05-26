package com.spring.study.dao;

import com.spring.study.model.Users;

/**
 * @Author：Haotian
 * @Date：2019/5/26 22:16
 */
public interface IUserDao {
    /**
     * 添加用户
     * @param users
     */
    void add(Users users);
}
