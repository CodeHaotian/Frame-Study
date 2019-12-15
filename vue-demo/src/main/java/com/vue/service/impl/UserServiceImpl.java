package com.vue.service.impl;

import com.vue.entity.Girl;
import com.vue.mapper.UserMapper;
import com.vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/15 18:58
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Girl> findAll() {
        return userMapper.findAll();
    }

    @Override
    public Girl findById(Integer id) {
        return userMapper.findById( id );
    }

    @Override
    public void update(Girl girl) {
        userMapper.update( girl );
    }
}
