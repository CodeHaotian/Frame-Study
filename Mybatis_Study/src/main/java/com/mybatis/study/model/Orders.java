package com.mybatis.study.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @Author：Haotian
 * @Date：2019/5/28 16:34
 */
@Getter
@Setter
@ToString
public class Orders {
    /**
     * @param id 订单编号
     * @param number 订单号
     * @param createtime 订单的创建时间
     * @param note 订单备注
     * @param id 订单编号
     */
    private Integer id;
    private String number;
    private Date createtime;
    private String note;

    /**
     * @param user 定单所属的用户
     */
    private User user;

    /**
     * 一对多数据封装
     */
    private List<OrderDetail> orderDetails;

}
