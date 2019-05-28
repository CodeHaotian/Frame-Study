package com.mybatis.study.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author：Haotian
 * @Date：2019/5/28 17:18
 */
@Getter
@Setter
public class OrderDetail {
    /**
     * @param id 定单详情ID
     * @param itemsId 商品ID
     * @param itemsNum 商品购买数量
     * @param items 商品模型
     */
    private Integer id;
    private Integer itemsId;
    private Integer itemsNum;

    private Items items;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", itemsId=" + itemsId +
                ", itemsNum=" + itemsNum +
                '}';
    }
}
