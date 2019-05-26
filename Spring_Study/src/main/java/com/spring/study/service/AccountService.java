package com.spring.study.service;

/**
 * @Author：Haotian
 * @Date：2019/5/26 17:15
 */
public interface AccountService {
    /**
     * 转账
     * @param outer 转出账号
     * @param inner 转入账号
     * @param money 转入金额
     */
    void transfer(String outer,String inner,Integer money);
}
