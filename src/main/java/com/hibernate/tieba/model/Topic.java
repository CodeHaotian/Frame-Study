package com.hibernate.tieba.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author：Haotian
 * @Date：2019/5/24 14:47
 */
@Data
@ToString(exclude = "replySet")
public class Topic {
    /**
     * description:帖子模型
     *
     * @param tid 帖子编号
     * @param title 帖子标题
     * @param topicContent 主题内容
     * @param ipAddr ip地址（作者）
     * @param lastReplyDate 最后回复时间
     * @param createDate 发帖时间（创建时间）
     * @param replySet 一对多： 一个主题 可以拥有 【多个回复】
     */
    private Integer tid;
    private String title;
    private String topicContent;
    private String ipAddr;
    private Date lastReplyDate;
    private Date createDate;

    private Set<Reply> replySet = new HashSet<Reply>();
}
