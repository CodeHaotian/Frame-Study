package com.spring.demo.dao;

import com.spring.demo.domain.Role;
import com.spring.demo.domain.User;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/9 15:53
 * @Description: 用户数据操作接口
 */
public interface UserDao {
    /**
     * 查询所有用户信息
     *
     * @return 用户信息集合
     */
    List<User> findAll();

    /**
     * 保存用户数据
     *
     * @param user 用户信息
     * @return 保存后的用户id
     */
    Long save(User user);

    /**
     * 保存用户与角色对应数据
     *
     * @param userId 用户id
     * @param roleId 角色id
     */
    void saveUserRoleRelation(Long userId, Long roleId);

    /**
     * 删除用户与角色的对应关系
     *
     * @param userId 用户id
     */

    void deleteUserRole(Long userId);

    /**
     * 根据用户id删除用户信息
     *
     * @param userId 用户id
     */
    void deleteUser(Long userId);

    /**
     * 查询用户信息
     *
     * @param username 用户名
     * @param password 用户密码
     * @return 用户信息
     */

    User login(String username, String password);
}
