package com.mybatis.study.dao;

import com.mybatis.study.model.User;

/**
 * @Author：Haotian
 * @Date：2019/5/27 20:38
 */
public interface UserDao {
    /**
     * 保存一个用户
     *
     * @param user
     */
    void save(User user);

    /**
     * 根据id查找用户
     *
     * @param id
     * @return
     */
    User findUserById(int id);
}
