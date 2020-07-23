package com.ssm.study.service.impl;

import com.ssm.study.mapper.UserMapper;
import com.ssm.study.entity.Girl;
import com.ssm.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Haotian
 * @version 1.0.0
 * @date 2020/7/23 8:59
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Girl> findAll(String name) {
        return userMapper.findAll( name );
    }
}
