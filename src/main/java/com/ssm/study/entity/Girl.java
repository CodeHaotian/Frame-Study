package com.ssm.study.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

/**
 * 用户实体类
 *
 * @author Haotian
 * @version 1.0.0
 * @date 2020/7/23 8:57
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Girl {
    private Integer id;
    private String name;
    private Integer age;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String phone;
    private String bwh;
    private String address;
    private String status;

    @Override
    public String toString() {
        return "Gril{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", bwh='" + bwh + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}