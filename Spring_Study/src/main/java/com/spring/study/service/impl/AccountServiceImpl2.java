package com.spring.study.service.impl;

import com.spring.study.dao.AccountDao;
import com.spring.study.service.AccountService;
import lombok.Setter;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @Author：Haotian
 * @Date：2019/5/26 17:18
 */
public class AccountServiceImpl2 implements AccountService {
    /**
     * 由Spring注入
     */
    @Setter
    private AccountDao accountDao;

    /**
     * Spring配置事务模版【由spring注入】
     * 出现异常自动回滚
     */

    @Override
    public void transfer(String outer, String inner, Integer money) {
        //扣钱
        accountDao.out( outer, money );
        //进账
        accountDao.in( inner, money );
    }
}
