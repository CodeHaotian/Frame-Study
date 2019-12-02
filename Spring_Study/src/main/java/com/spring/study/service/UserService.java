package com.spring.study.service;

import com.spring.study.model.Users;

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
    void add(Users user);

    /**
     * 删除用户
     */
    void delete();

    /**
     * 动态代理测试方法
     * @param name 存放数据
     * @return 返回值
     */
    String test(String name);
}
