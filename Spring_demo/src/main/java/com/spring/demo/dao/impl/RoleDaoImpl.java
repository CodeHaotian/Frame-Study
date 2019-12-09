package com.spring.demo.dao.impl;

import com.spring.demo.dao.RoleDao;

import com.spring.demo.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/9 10:05
 * @Description: 角色数据操作实现
 */
@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Role> findAll() {
        String sql = "select  * from sys_role";
        return jdbcTemplate.query( sql, new BeanPropertyRowMapper<>( Role.class ) );
    }

    @Override
    public void save(Role role) {
        String sql = "insert into sys_role values ( ?,?,? )";
        jdbcTemplate.update( sql, null, role.getRoleName(), role.getRoleDesc() );
    }

    @Override
    public List<Role> findRoleByUserId(Long id) {
        String sql = "select * from sys_user_role ur,sys_role r where ur.roleId = r.id and ur.userId = ?";
        return jdbcTemplate.query( sql, new BeanPropertyRowMapper<>( Role.class ), id );
    }

    @Override
    public void deleteRoleUser(Long roleId) {
        jdbcTemplate.update( "delete from sys_user_role where roleId = ?", roleId );
    }

    @Override
    public void delete(Long roleId) {
        jdbcTemplate.update( "delete from sys_role where id = ?", roleId );
    }
}
