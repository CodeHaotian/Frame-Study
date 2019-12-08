//package com.spring.study.dao.impl;
//
//import com.spring.study.dao.AccountDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
///**
// * @Author：Haotian
// * @Date：2019/5/26 17:05
// * 使用JdbcTemplate操作数据库
// */
//@Repository
//public class AccountDaoImpl2 implements AccountDao {
//    JdbcTemplate jdbcTemplate = new JdbcTemplate();
//
//    @Override
//    public void out(String outer, Integer money) {
//        jdbcTemplate.update( "update account set money = money - ? where username = ?", money, outer );
//    }
//
//    @Override
//    public void in(String inner, Integer money) {
//        jdbcTemplate.update( "update account set money = money + ? where username = ?", money, inner );
//    }
//}