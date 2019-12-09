package com.spring.demo.service;

import com.spring.demo.domain.Role;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/9 10:01
 * @Description: 角色操作接口
 */
public interface RoleService {
    /**
     * 列出所有角色信息
     *
     * @return 角色数据列表
     */
    List<Role> list();

    /**
     * 保存用户
     *
     * @param role 用户
     */
    void save(Role role);

    /**
     * 删除角色
     *
     * @param roleId 角色id
     */
    void delete(Long roleId);
}
