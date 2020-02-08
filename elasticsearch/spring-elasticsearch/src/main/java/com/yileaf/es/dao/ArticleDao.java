package com.yileaf.es.dao;

import com.yileaf.es.entity.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2020/2/8 16:06
 * @Description: 文章crud接口
 */
public interface ArticleDao extends ElasticsearchRepository<Article, Long> {
    /**
     * 按照规则自定义查询方法
     *
     * @param title 标题
     * @return 匹配内容
     */
    List<Article> findByTitle(String title);

    /**
     * 按照规则自定义查询方法
     *
     * @param title   标题
     * @param content 内容
     * @return 满足其一匹配内容
     */
    List<Article> findByTitleOrContent(String title, String content);

    /**
     * 按照规则自定义查询方法并分页
     *
     * @param title    标题
     * @param content  内容
     * @param pageable 分页信息
     * @return 满足其一匹配内容
     */
    List<Article> findByTitleOrContent(String title, String content, Pageable pageable);
}