package com.hibernate.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author：Haotian
 * @Date：2019/5/22 16:36
 */
@Getter
@Setter
public class Order {
    /**
     * description: 订单实体类
     *
     * @param id 订单ID,以后工作中订单ID一般都UUID类型
     * @param name 订单名称
     * @param customer 订单只属于某个客户
     */
    private Integer id;
    private String name;
    private Customer customer;
}
