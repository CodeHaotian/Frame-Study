package com.spring.study.aspect;

/**
 * @author Haotian
 * 切面类：增加代码 与 切入点 结合
 */
public class MyAspect2 {

    public void before() {
        System.out.println( "开启事务..." );
    }

    public void after() {
        System.out.println( "提交事务..." );
    }
}
