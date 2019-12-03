package com.spring.study.service.impl;

import com.spring.study.dao.AccountDao;
import com.spring.study.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author：Haotian
 * @Date：2019/5/26 17:18
 */
@Service
@Transactional
public class AccountServiceImpl2 implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public void transfer(String outer, String inner, Integer money) {
        //扣钱
        accountDao.out( outer, money );
        int i = 1/0;
        //进账
        accountDao.in( inner, money );
    }
}
