package com.yileaf.es.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Author: Haotian
 * @Date: 2020/2/8 15:58
 * @Description: 文章实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "index_study", type = "article")
public class Article {
    @Id
    @Field(type = FieldType.Long, store = true)
    private long id;
    @Field(type = FieldType.Text, store = true, analyzer = "ik_smart")
    private String title;
    @Field(type = FieldType.Text, store = true, analyzer = "ik_smart")
    private String content;
}
