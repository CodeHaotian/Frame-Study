package com.spring.study.dao.impl;

import com.spring.study.dao.GirlDao;
import com.spring.study.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/11/30 19:56
 * @Description: 数据操作具体实现
 */
@Repository
public class GirlDaoImpl  implements GirlDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GirlDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void add(Girl girl) {
        String sql = "insert into girl values ( null,?,?,?,?,?,?,?,null )";
        jdbcTemplate.update( sql, girl.getName(), girl.getAge(), girl.getBirthday(), girl.getCup(), girl.getLeg(), girl.getPhone(), girl.getAddress() );
    }

    @Override
    public void update(Girl girl) {
        String sql = "update girl set age = ? where id = ?";
        jdbcTemplate.update( sql, girl.getAge(), girl.getId() );
    }

    @Override
    public List<Girl> findAll() {
        String sql = "select * from girl WHERE status = 'Y'";
        return jdbcTemplate.query( sql, new BeanPropertyRowMapper<>( Girl.class ) );
    }

    @Override
    public void delete(Integer id) {
        String sql = "update girl set status = 'N' WHERE id = ?";
        jdbcTemplate.update( sql, id );
    }

    @Override
    public Girl findById(Integer id) {
        String sql = "select * from girl where  id = ?";
        return jdbcTemplate.queryForObject( sql, new BeanPropertyRowMapper<>( Girl.class ), id );
    }
}
