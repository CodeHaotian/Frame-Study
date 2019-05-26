package com.spring.study.dao;

/**
 * @Author：Haotian
 * @Date：2019/5/26 17:02
 */
public interface AccountDao {
    /**
     *扣钱
     * @param outer
     * @param money
     */
    void out(String outer,Integer money);

    /**
     *进账
     * @param inner
     * @param money
     */
    void in(String inner,Integer money);
}
