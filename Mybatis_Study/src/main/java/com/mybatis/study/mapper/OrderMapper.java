package com.mybatis.study.mapper;

import com.mybatis.study.model.Orders;
import com.mybatis.study.model.OrdersExt;

import java.util.List;

/**
 * @Author：Haotian
 * @Date：2019/5/28 16:43
 */
public interface OrderMapper {
    /**
     * 根据id关联查询用户信息
     *
     * @param id
     * @return
     */
    OrdersExt findOrderById(int id);

    /**
     * 模型中嵌套单个模型查询
     *
     * @param id
     * @return
     */
    Orders findOrderById2(int id);

    /**
     * 模型中嵌套多个模型查询
     *
     * @param id
     * @return
     */
    Orders findOrderById3(int id);

    /**
     * 懒加载定单的用户数据
     *
     * @return
     */
    List<Orders> findOrderAndUserByLazyloading();
}
