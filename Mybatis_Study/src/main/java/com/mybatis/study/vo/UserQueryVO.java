package com.mybatis.study.vo;

import com.mybatis.study.model.User;
import lombok.Data;

import java.util.List;

/**
 * @Author：Haotian
 * @Date：2019/5/27 21:33
 */
@Data
public class UserQueryVO {
    private User user;
    private List<Integer> ids;
}
