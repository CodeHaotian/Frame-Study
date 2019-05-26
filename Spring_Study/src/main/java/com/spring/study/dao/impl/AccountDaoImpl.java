package com.spring.study.dao.impl;

import com.spring.study.dao.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @Author：Haotian
 * @Date：2019/5/26 17:05
 * 使用spring-jdbc操作数据库
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void out(String outer, Integer money) {
        getJdbcTemplate().update( "update account set money = money - ? where username = ?", money, outer );
    }

    @Override
    public void in(String inner, Integer money) {
        getJdbcTemplate().update( "update account set money = money + ? where username = ?", money, inner );

    }
}
