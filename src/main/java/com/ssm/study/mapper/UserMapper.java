package com.ssm.study.mapper;

import com.ssm.study.entity.Girl;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/13 20:21
 */
public interface UserMapper {
    /**
     * 根据用户名查询用户
     *
     * @param name 用户名
     * @return 相应数据集合
     */
    List<Girl> findAll(String name);
}
