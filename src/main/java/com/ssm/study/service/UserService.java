package com.ssm.study.service;

import com.ssm.study.entity.Girl;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/13 20:30
 */
public interface UserService {
    List<Girl> findAll(String name);
}
