package com.ssm.study.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：Haotian
 * @Date：2019/5/30 16:55
 */
@Getter
@Setter
public class UserExt1 {
    private User1 user1;
    private List<User1> user1s = new ArrayList<User1>();
    private Map<String, Object> infos = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "UserExt{" +
                "user=" + user1 +
                '}';
    }
}
