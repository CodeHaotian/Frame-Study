package com.spring.demo.dao;

import com.spring.demo.domain.Role;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/9 10:04
 * @Description: 角色数据操作接口
 */
public interface RoleDao {
    /**
     * 查询角色表所有信息
     *
     * @return 角色数据集合
     */
    List<Role> findAll();

    /**
     * 向数据库保存角色数据
     *
     * @param role 角色
     */
    void save(Role role);

    /**
     * 根据用户id查询用户所属权限
     *
     * @param id 用户id
     * @return 当前用户对应权限集合
     */
    List<Role> findRoleByUserId(Long id);

    /**
     * 删除角色与用户的对应关系
     *
     * @param roleId 角色id
     */

    void deleteRoleUser(Long roleId);

    /**
     * 根据角色id删除角色信息
     *
     * @param roleId 角色id
     */
    void delete(Long roleId);
}
