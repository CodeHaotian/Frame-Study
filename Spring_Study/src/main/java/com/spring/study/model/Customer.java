package com.spring.study.model;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author：Haotian
 * @Date：2019/5/25 15:41
 */
@Data
public class Customer {
    /**
     * description: Spring参数注入模型
     *
     * @param name 名字
     * @param sex 性别
     * @param pi 圆周率
     * @param cars 车的种类
     * @param pats 宠物种类
     * @param infos 信息
     * @param mysqlInfos mysql数据连接信息
     * @param members 家庭成员
     * @param address 地址
     */
    private String name;
    private String sex = "男";
    private double pi;
    private List<String> cars;
    private Set<String> pats;
    private Map<String, String> infos;
    private Properties mysqlInfos;
    private String[] members;
    private Address address;
}
