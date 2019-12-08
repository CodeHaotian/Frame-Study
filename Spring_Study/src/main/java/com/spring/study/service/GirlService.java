package com.spring.study.service;

import com.spring.study.domain.Girl;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/11/30 20:02
 * @Description: 操作用户方法接口
 */
public interface GirlService {
    /**
     * 添加用户
     *
     * @param girl 用户
     */
    void add(Girl girl);

    /**
     * 修改用户信息
     *
     * @param girl 用户
     */
    void update(Girl girl);

    /**
     * 查询所有用户
     *
     * @return 用户信息集合
     */
    List<Girl> findAll();

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
    Girl findByTd(Integer id);
}
