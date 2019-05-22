package com.hibernate.domain;

import lombok.Data;

/**
 * @Author：Haotian
 * @Date：2019/5/21 17:18
 */
@Data
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String sex;
}
