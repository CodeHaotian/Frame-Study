package com.hibernate.tieba.service.impl;

import com.hibernate.tieba.dao.TopicDao;
import com.hibernate.tieba.dao.impl.TopicDaoImpl;
import com.hibernate.tieba.model.Topic;
import com.hibernate.tieba.service.TopicService;

import java.util.List;

/**
 * @Author：Haotian
 * @Date：2019/5/24 17:15
 */
public class TopicServiceImpl implements TopicService {
    private TopicDao dao = new TopicDaoImpl();

    @Override
    public void save(Topic topic) {
        dao.save( topic );
    }

    @Override
    public List<Topic> getAll(String key) {
        return dao.getAll( key );
    }
}
