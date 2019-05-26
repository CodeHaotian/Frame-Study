package com.spring.study.service;

import com.spring.study.model.Users;

/**
 * @Author：Haotian
 * @Date：2019/5/26 22:14
 */
public interface IUserService {
    /**
     * 添加用户
     * @param users
     */
    void register(Users users);
}
