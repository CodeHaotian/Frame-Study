package com.mybatis.study.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author：Haotian
 * @Date：2019/5/28 20:54
 */
@Getter
@Setter
@ToString
public class Items {
    private Integer id;
    private String name;
    private String price;
    private String detail;
}
