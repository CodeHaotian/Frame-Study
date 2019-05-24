package com.hibernate.tieba.dao.impl;

import com.hibernate.tieba.dao.TopicDao;
import com.hibernate.tieba.model.Topic;
import com.hibernate.utils.HibernateUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @Author：Haotian
 * @Date：2019/5/24 16:50
 */
public class TopicDaoImpl implements TopicDao {
    private Session session = HibernateUtils.getCurrentSession();

    @Override
    public void save(Topic topic) {
        //保存数据
        session.save( topic );
    }

    @Override
    public List<Topic> getAll(String key) {
        //条件是否存在
        Query query = null;
        if (StringUtils.isEmpty( key )) {
            query = session.createQuery( "from Topic" );
        } else {
            query = session.createQuery( "from Topic where title like :like" );
            query.setParameter( "like", "%" + key + "%" );
        }
        return query.list();
    }
}
