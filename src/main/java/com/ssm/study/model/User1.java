package com.ssm.study.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Date;

/**
 * @Author：Haotian
 * @Date：2019/5/29 22:10
 */
@Getter
@Setter
public class User1 {
    private Integer id;

    private String username;
    private String password;
    private int age;
    private String gender;
    private Date birthday;
    private String[] hobbyIds;

    public User1(String username, int age, String gender, Date birthday) {
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", hobbyIds=" + Arrays.toString( hobbyIds ) +
                '}';
    }
}
