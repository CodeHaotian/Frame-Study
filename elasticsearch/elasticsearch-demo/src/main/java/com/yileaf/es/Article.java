package com.yileaf.es;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Haotian
 * @Date: 2020/2/7 19:20
 * @Description: 文章实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {
    private long id;
    private String title;
    private String content;
}