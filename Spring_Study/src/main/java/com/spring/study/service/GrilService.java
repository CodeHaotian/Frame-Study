package com.spring.study.service;

import com.spring.study.domain.Gril;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/11/30 20:02
 * @Description: 操作用户方法接口
 */
public interface GrilService {
    /**
     * 添加用户
     *
     * @param gril 用户
     */
    void add(Gril gril);

    /**
     * 修改用户信息
     *
     * @param gril 用户
     */
    void update(Gril gril);

    /**
     * 查询所有用户
     *
     * @return 用户信息集合
     */
    List<Gril> findAll();

    /**
     * 删除指定用户
     *
     * @param id 用户id
     */
    void delete(Integer id);

    /**
     * 查询指定用户
     * @param id 用户id
     * @return 用户数据封装类
     */
    Gril findByTd(Integer id);
}
