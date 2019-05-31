package com.ssm.study.service.impl;

import com.ssm.study.mapper.ItemsMapper;
import com.ssm.study.model.Items;
import com.ssm.study.service.IItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author：Haotian
 * @Date：2019/5/30 22:08
 */
@Service
@Transactional
public class IItemsServiceImpl implements IItemsService {
    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> findAllItems() {
        return itemsMapper.findAllItems();
    }

    @Override
    public Items findById(Integer id) {
        return itemsMapper.selectByPrimaryKey( id );
    }

    @Override
    public void saveOrUpdate(Items items) {
        if (items.getId() == null) {
            itemsMapper.insert( items );
        } else {
            itemsMapper.updateByPrimaryKeySelective( items );
        }
    }

    @Override
    public void deleteById(Integer id) {
        itemsMapper.deleteByPrimaryKey( id );
    }
}
