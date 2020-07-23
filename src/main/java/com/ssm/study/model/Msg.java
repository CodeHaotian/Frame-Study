package com.ssm.study.model;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 数据封装类
 *
 * @author Haotian
 * @version 1.0.0
 * @date 2020/7/23 8:58
 **/
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
