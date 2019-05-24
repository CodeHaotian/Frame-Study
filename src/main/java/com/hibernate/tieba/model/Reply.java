package com.hibernate.tieba.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author：Haotian
 * @Date：2019/5/24 14:46
 */
@Data
@ToString(exclude = "topic")
public class Reply {
    /**
     * description:回复模型
     *
     * @param rid 回复主题编号
     * @param replyContent 回复的内容
     * @param ipAddr 作者（回复人）
     * @param createDate 回帖时间
     * @param topic 多对一：多个回复  属于 【一个主题】
     */
    private Integer rid;
    private String replyContent;
    private String ipAddr;
    private Date createDate;

    private Topic topic;
}
