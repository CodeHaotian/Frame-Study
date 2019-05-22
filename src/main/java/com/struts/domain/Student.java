package com.struts.domain;

import lombok.*;

/**
 * 学生实体类
 *
 * @Author：Haotian
 * @Date：2019/5/18 21:36
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    /**
     * 不能为空，去空字符串
     */
    private String username;
    /**
     * 18~100
     */
    private int age;
    /**
     * 正确邮箱格式
     */
    private String email;
    /**
     * 长度3~8
     */
    private String password;
    /**
     * 与密码一至
     */
    private String repassword;
    /**
     * 必须是自然数
     */
    private int score;
    /**
     * 必须是一个路径 http://
     */
    private String url;
    /**
     * 性别，只有男和女
     */
    private String gender;

}
