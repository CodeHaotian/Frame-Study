package com.spring.study.dao;

import com.spring.study.domain.Gril;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/11/30 19:54
 * @Description: 数据操作接口
 */
public interface GrilDao {
    /**
     * 添加富婆信息
     * @param gril 富婆
     */
    void add(Gril gril);

    /**
     * 修改富婆信息
     * @param gril 指定条件
     */
    void update(Gril gril);

    /**
     * 查询所有富婆信息
     * @return 富婆信息集合
     */
    List<Gril> findAll();

    /**
     * 删除富婆信息
     * @param id 富婆id
     */
    void delete(Integer id);

    /**
     * 查找指定富婆信息
     * @param id 富婆id
     * @return 富婆数据封装类
     */
    Gril findById(Integer id);
}
