package com.vue.service;

import com.vue.entity.Girl;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/15 18:57
 */
public interface UserService {
    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    List<Girl> findAll();

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return 指定用户数据
     */
    Girl findById(Integer id);

    /**
     * 更新用户数据
     *
     * @param girl 新用户数据
     */
    void update(Girl girl);
}
