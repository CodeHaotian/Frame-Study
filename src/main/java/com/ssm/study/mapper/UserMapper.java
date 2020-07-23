package com.ssm.study.mapper;

import com.ssm.study.entity.Girl;

import java.util.List;

/**
 * @author Haotian
 * @version 1.0.0
 * @date 2020/7/23 8:57
 **/
public interface UserMapper {
    /**
     * 根据用户名查询用户
     *
     * @param name 用户名
     * @return 相应数据集合
     */
    List<Girl> findAll(String name);
}
