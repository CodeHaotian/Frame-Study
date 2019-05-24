package com.hibernate.tieba.service;

import com.hibernate.tieba.model.Topic;

import java.util.List;

/**
 * @Author：Haotian
 * @Date：2019/5/24 17:04
 */
public interface TopicService {
    /**
     * 保存帖子
     * @param topic
     */
    void save(Topic topic);

    /**
     * 查询帖子
     * @param key 指定条件
     * @return 符合条件的帖子
     */
    List<Topic> getAll(String key);
}
