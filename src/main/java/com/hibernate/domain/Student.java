package com.hibernate.domain;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author：Haotian
 * @Date：2019/5/22 21:18
 */
@Data
public class Student {
    /**
     * description:学生实体类
     *
     * @param id 学生编号
     * @param name 学生姓名
     */
    private Integer sid;
    private String name;

    private Set<Course> courses = new HashSet<Course>();
}
