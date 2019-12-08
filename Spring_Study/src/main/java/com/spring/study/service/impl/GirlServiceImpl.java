package com.spring.study.service.impl;

import com.spring.study.dao.GirlDao;
import com.spring.study.domain.Girl;
import com.spring.study.service.GirlService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/11/30 20:03
 * @Description: 用户操作方法实现
 */
@Transactional(rollbackFor = Exception.class)
@Service

public class GirlServiceImpl implements GirlService {
    private final GirlDao girlDao;

    public GirlServiceImpl(GirlDao girlDao) {
        this.girlDao = girlDao;
    }

    @Override
    public void add(Girl girl) {
        girlDao.add( girl );
    }

    @Override
    public void update(Girl girl) {
        girlDao.update( girl );
    }

    @Override
    public List<Girl> findAll() {
        return girlDao.findAll();
    }

    @Override
    public void delete(Integer id) {
        girlDao.delete( id );
    }

    @Override
    public Girl findByTd(Integer id) {
        return girlDao.findById( id );
    }
}
