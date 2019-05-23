package com.hibernate.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author：Haotian
 * @Date：2019/5/23 22:19
 */
@Getter
@Setter
public class Company {
    /**
     * description:
     *
     * @param id 公司id
     * @param name 公司名字
     * @param address 一个公司对应一个地址
     */
    private Integer id;
    private String name;

    private Address address;
}
