package com.hibernate.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Author：Haotian
 * @Date：2019/5/22 16:38
 */
@Getter
@Setter
public class Customer {
    /**
     * description:
     *
     * @param id 客户id
     * @param name 客户名称
     * @param orders 一对多属性描述，一个客户有n个订单
     */
    private Integer id;
    private String name;
    private Set<Order> orders = new HashSet<Order>();
}
