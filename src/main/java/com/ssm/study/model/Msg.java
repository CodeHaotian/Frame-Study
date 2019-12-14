package com.ssm.study.model;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author: Haotian
 * @Date: 2019/12/13 21:07
 * @Description: 数据封装类
 */
@Component
@Data
public class Msg {
    private Integer code;
    private Object data;
    private String message;
    private Long count;

    public void set(Integer code, String message, Long count, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
    }
}
