package com.spring.study.dao.impl;

import com.spring.study.dao.IUserDao;
import com.spring.study.model.Users;
import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 * @Author：Haotian
 * @Date：2019/5/26 22:17
 */
public class IUserDaoImpl implements IUserDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void add(Users users) {
        hibernateTemplate.save( users );
    }
}
