package com.mybatis.study.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author：Haotian
 * @Date：2019/5/28 16:41
 */
@Setter
@Getter
public class OrdersExt extends Orders {
    private String username;
    private String address;

    @Override
    public String toString() {
        return "OrdersExt{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}' + super.toString();
    }
}
