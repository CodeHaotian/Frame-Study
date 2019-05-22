package com.hibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author：Haotian
 * @Date：2019/5/22 21:19
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    /**
     * description: 课程实体类
     *
     * @param cid 课程编号
     * @param name 课程名
     */
    private Integer cid;
    private String name;

    private Set<Student> students = new HashSet<Student>();
}
