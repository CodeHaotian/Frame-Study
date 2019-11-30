package com.spring.study.service.impl;

import com.spring.study.dao.IUserDao;
import com.spring.study.model.Users;
import com.spring.study.service.IUserService;

/**
 * @Author：Haotian
 * @Date：2019/5/26 22:24
 */
public class IUserServiceImpl implements IUserService {

    private IUserDao userDao;

    public IUserServiceImpl(IUserDao userDao) {

    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register(Users users) {
        userDao.add( users );
    }
}
