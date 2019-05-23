package com.hibernate.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author：Haotian
 * @Date：2019/5/23 22:17
 */
@Getter
@Setter
public class Address {
    /**
     * description:地址实体类
     *
     * @param id 地址id
     * @param name 地址名称
     * @param company 一个地址对应一个公司
     */
    private Integer id;
    private String name;

    private Company company;

}
