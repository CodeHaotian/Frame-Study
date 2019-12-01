package com.spring.study.domain;

import lombok.*;

import java.util.Date;

/**
 * @Author: Haotian
 * @Date: 2019/11/30 19:35
 * @Description: 实体类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gril {
    private Integer id;
    private String name;
    private Integer age;
    private Date birthday;
    private String cup;
    private String leg;
    private String phone;
    private String address;
    private String status;

    @Override
    public String toString() {
        return "Gril{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", cup='" + cup + '\'' +
                ", leg='" + leg + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
