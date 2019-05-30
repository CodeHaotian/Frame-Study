package com.ssm.study.service;

import com.ssm.study.model.Items;

import java.util.List;

/**
 * @Author：Haotian
 * @Date：2019/5/30 22:03
 */
public interface IItemsService {
    /**
     * 查找所有的订单
     * @return
     */
    List<Items> findAllItems();

    /**
     * 根据ID查找订单
     *
     * @param id
     * @return
     */
    Items findById(Integer id);

    /**
     * 更新订单
     *
     * @param items
     */
    void saveOrUpdate(Items items);

    /**
     * 根据编号，删除订单
     *
     * @param id
     */
    void deleteById(Integer id);
}
