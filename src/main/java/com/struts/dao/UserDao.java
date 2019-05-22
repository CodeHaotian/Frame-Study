package com.struts.dao;

import com.struts.domain.User;

/**
 * 用户操作类
 *
 * @Author：Haotian
 * @Date：2019/5/17 23:25
 */
public interface UserDao {
    /**
     * description: 添加用户
     *
     * @param user 用户数据
     * @return int
     */
    int addUser(User user);
}
