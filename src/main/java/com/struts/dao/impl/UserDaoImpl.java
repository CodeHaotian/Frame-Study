package com.struts.dao.impl;

import com.struts.dao.UserDao;
import com.struts.domain.User;
import com.struts.util.DruidUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 用户操作实现类
 *
 * @Author：Haotian
 * @Date：2019/5/17 23:27
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate( DruidUtils.getDataSource() );

    @Override
    public int addUser(User user) {
        try {
            String sql = " insert into struts_user values(?,?,?,?,?) ";
            /*update返回值就是执行sql语句受影响行数*/
            return template.update( sql, user.getUsername(), user.getPassword(), user.getBirthday(), user.getHobby(), user.isMarried() );
        } catch (DataAccessException e) {
            throw new RuntimeException( e );
        }
    }
}
