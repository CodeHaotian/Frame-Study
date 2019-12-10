package com.mybatis.study.model;

import cn.hutool.core.date.DateUtil;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/10 10:19
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
    /**
     * @param id 用户编号
     * @param username 用户姓名
     * @param sex 性别
     * @param birthday 生日
     * @param address 地址
     * @param orderList 一个用户有多张定单
     */
    private Integer id;
    private String username;
    private String sex;
    private Date birthday;
    private String address;

    private List<Orders> orderList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + DateUtil.formatDate( birthday ) +
                ", address='" + address + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}