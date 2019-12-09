package com.spring.demo.service.impl;

import com.spring.demo.dao.RoleDao;
import com.spring.demo.dao.UserDao;
import com.spring.demo.domain.Role;
import com.spring.demo.domain.User;
import com.spring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/9 15:50
 * @Description: 用户功能实现
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        //封装userList中的每一个User的roles数据
        for (User user : userList) {
            //获取用户的id
            Long id = user.getId();
            //根据id查询对应角色权限
            List<Role> roles = roleDao.findRoleByUserId( id );
            //将角色数据进行封装
            user.setRoles( roles );
        }
        //返回所有数据
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        //第一步 向sys_user表中存储数据,并返回当时保存用户所生产的id
        Long userId = userDao.save( user );
        //第二步 向sys_user_role 关系表中存储多条数据
        for (Long roleId : roleIds) {
            userDao.saveUserRoleRelation( userId, roleId );
        }
    }

    @Override
    public void delete(Long userId) {
        //删除sys_user_role关系表中对应数据
        userDao.deleteUserRole( userId );
        //删除sys_user表用户数据
        userDao.deleteUser( userId );
    }

    @Override
    public User login(String username, String password) {
        return userDao.login( username, password );

    }
}
