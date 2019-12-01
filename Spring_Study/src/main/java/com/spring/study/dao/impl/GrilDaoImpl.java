package com.spring.study.dao.impl;

import com.spring.study.dao.GrilDao;
import com.spring.study.domain.Gril;
import com.sun.xml.bind.v2.model.core.ID;
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
public class GrilDaoImpl implements GrilDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Gril gril) {
        String sql = "insert into gril values ( null,?,?,?,?,?,?,?,null )";
        jdbcTemplate.update( sql, gril.getName(), gril.getAge(), gril.getBirthday(), gril.getCup(), gril.getLeg(), gril.getPhone(), gril.getAddress() );
    }

    @Override
    public void update(Gril gril) {
        String sql = "update gril set age = ? where id = ?";
        jdbcTemplate.update( sql, gril.getAge(), gril.getId() );
    }

    @Override
    public List<Gril> findAll() {
        String sql = "select * from gril WHERE status = 'Y'";
        return jdbcTemplate.query( sql, new BeanPropertyRowMapper<>( Gril.class ) );
    }

    @Override
    public void delete(Integer id) {
        String sql = "update gril set status = 'N' WHERE id = ?";
        jdbcTemplate.update( sql, id );
    }

    @Override
    public Gril findById(Integer id) {
        String sql = "select * from gril where  id = ?";
        return jdbcTemplate.queryForObject( sql, new BeanPropertyRowMapper<>( Gril.class ), id );
    }
}
