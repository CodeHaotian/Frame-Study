package com.struts.domain;

import lombok.*;

import java.util.Date;

/**
 * 用户实体类
 *
 * @Author：Haotian
 * @Date：2019/5/17 22:44
 */

/*生成无参构造方法*/
@NoArgsConstructor

/*生成全参构造方法*/
@AllArgsConstructor

/*生成Getter，静态属性除外*/
@Getter

/*生成Setter，静态属性除外*/
@Setter

/*生成ToString*/
@ToString

public class User {
    private String username;
    private String password;
    private Date birthday;
    private String hobby;
    private boolean married;
}
