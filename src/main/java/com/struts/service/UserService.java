package com.struts.service;

import com.struts.domain.User;

/**
 * 用户操作方法类
 * @Author：Haotian
 * @Date：2019/5/17 23:45
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    void register(User user);
}
