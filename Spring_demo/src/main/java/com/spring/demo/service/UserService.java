package com.spring.demo.service;

import com.spring.demo.domain.User;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/9 15:48
 * @Description: 用户操作接口
 */
public interface UserService {
    /**
     * 列出所有用户信息
     *
     * @return 用户数据列表
     */
    List<User> list();

    /**
     * 添加用户
     *
     * @param user    用户信息
     * @param roleIds 用户所拥有的权限id集合
     */
    void save(User user, Long[] roleIds);

    /**
     * 删除用户
     * @param userId 用户id
     */

    void delete(Long userId);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 用户密码
     * @return 用户对应信息
     */
    User login(String username, String password);
}
