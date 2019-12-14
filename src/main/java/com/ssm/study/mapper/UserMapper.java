package com.ssm.study.mapper;

import com.ssm.study.entity.Girl;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/13 20:21
 */
public interface UserMapper {
    List<Girl> findAll(String name);
}
