package com.ssm.study.service;

import com.ssm.study.entity.Girl;

import java.util.List;

/**
 * @author Haotian
 * @version 1.0.0
 * @date 2020/7/23 8:58
 **/
public interface UserService {
    /**
     * 查询用户
     *
     * @param name 用户名
     * @return 数据集合
     */
    List<Girl> findAll(String name);
}
