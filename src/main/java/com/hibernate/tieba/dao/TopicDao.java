package com.hibernate.tieba.dao;

import com.hibernate.tieba.model.Topic;

import java.util.List;

/**
 * @Author：Haotian
 * @Date：2019/5/24 16:46
 */
public interface TopicDao {
    /**
     * 保存帖子
     * @param topic 帖子对象
     */
    void save(Topic topic);

    /**
     * 返回帖子列表
     * @param key 搜索条件
     * @return 符合条件贴
     */
    List<Topic> getAll(String key);
}
