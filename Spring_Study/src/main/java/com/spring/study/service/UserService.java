package com.spring.study.service;

import com.spring.study.model.User;

/**
 * @Author：Haotian
 * @Date：2019/5/24 21:40
 */
public interface UserService {
    /**
     * 添加用户
     *
     * @param user
     */
    void add(User user);

    /**
     * 删除用户
     */
    void delete();
}
