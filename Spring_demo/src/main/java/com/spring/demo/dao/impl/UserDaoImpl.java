package com.spring.demo.dao.impl;

import com.spring.demo.dao.UserDao;
import com.spring.demo.domain.Role;
import com.spring.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/9 15:55
 * @Description: 用户数据操作实现
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        String sql = "select  * from sys_user";
        return jdbcTemplate.query( sql, new BeanPropertyRowMapper<>( User.class ) );
    }

    @Override
    public Long save(User user) {
        //创建PreparedStatementCreator
        PreparedStatementCreator preparedStatementCreator = con -> {
            //使用原始jdbc完成有个PreparedStatement的组建
            PreparedStatement preparedStatement = con.prepareStatement( "insert into  sys_user values ( ?,?,?,?,? )", PreparedStatement.RETURN_GENERATED_KEYS );
            preparedStatement.setObject( 1, null );
            preparedStatement.setString( 2, user.getUsername() );
            preparedStatement.setString( 3, user.getEmail() );
            preparedStatement.setString( 4, user.getPassword() );
            preparedStatement.setString( 5, user.getPhoneNum() );
            return preparedStatement;

        };
        //创建keyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        //使用此方式插入数据，可以获得插入后的id
        jdbcTemplate.update( preparedStatementCreator, keyHolder );
        //获得生成的主键,并返回
        return keyHolder.getKey().longValue();
    }

    @Override
    public void saveUserRoleRelation(Long userId, Long roleId) {
        jdbcTemplate.update( "insert into sys_user_role values (?,?)", userId, roleId );
    }

    @Override
    public void deleteUserRole(Long userId) {
        jdbcTemplate.update( "delete from sys_user_role where userId = ?", userId );
    }

    @Override
    public void deleteUser(Long userId) {
        jdbcTemplate.update( "delete from sys_user where id = ?", userId );
    }

    @Override
    public User login(String username, String password) {
        String sql = " select  * from sys_user where username = ? and password = ?";
        try {
            return jdbcTemplate.queryForObject( sql, new BeanPropertyRowMapper<>( User.class ), username, password );
        } catch (Exception e) {
            return null;
        }
    }

}
