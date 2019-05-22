package com.struts.service.impl;

import com.struts.dao.UserDao;
import com.struts.dao.impl.UserDaoImpl;
import com.struts.domain.User;
import com.struts.service.UserService;

/**
 * 用户操作方法实现类
 *
 * @Author：Haotian
 * @Date：2019/5/17 23:47
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public void register(User user) {
        dao.addUser( user );
    }
}
