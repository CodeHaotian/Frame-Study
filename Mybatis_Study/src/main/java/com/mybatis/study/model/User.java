package com.mybatis.study.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author：Haotian
 * @Date：2019/5/27 16:12
 */
@Getter
@Setter
@ToString
public class User implements Serializable {
    /**
     * @param id 用户编号
     * @param username 用户姓名
     * @param sex 性别
     * @param birthday 生日
     * @param address 地址
     */
    private int id;
    private String username;
    private String sex;
    private Date birthday;
    private String address;

    public User() {
    }

    public User(String username, String sex, Date birthday, String address) {
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
    }

}
