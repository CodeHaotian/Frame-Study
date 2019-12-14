package com.ssm.study.service.impl;

import com.ssm.study.mapper.UserMapper;
import com.ssm.study.entity.Girl;
import com.ssm.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/13 20:31
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Girl> findAll(String name) {
        return userMapper.findAll(name);
    }
}
