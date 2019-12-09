package com.spring.demo.service.impl;

import com.spring.demo.dao.RoleDao;
import com.spring.demo.domain.Role;
import com.spring.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/9 10:00
 * @Description: 角色功能实现
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> list() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save( role );
    }

    @Override
    public void delete(Long roleId) {
        //删除sys_user_role关系表中对应数据
        roleDao.deleteRoleUser( roleId );
        //删除sys_role表角色数据
        roleDao.delete( roleId );
    }
}
