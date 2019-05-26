package com.spring.study.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author：Haotian
 * @Date：2019/5/26 15:41
 */
@Component
@Aspect
public class MyAspect {
    /**
     * 声明一个公共的切入点
     */
    @Pointcut("execution(* com.spring.study.service.impl.UserServiceImpl.*(..))")
    public void myPointcut() {
    }

    @Before("myPointcut()")
    public void myBefore(JoinPoint jp) {
        //连接点方法名
        System.out.println( "1.前置通知..." + jp.getSignature().getName() );
    }

    /**
     * 后置通知获取service方法执行后的返回值
     * Object retValue:service方法执行的返回值,如果写了返回值，需要在xml中配置returning
     * <aop:after-returning method="myAfterReturning" pointcut-ref="myPointcut" returning="retValue"/>
     *
     * @param jp
     */
    @AfterReturning(pointcut = "myPointcut()", returning = "retValue")
    public void myAfterReturning(JoinPoint jp, Object retValue) {
        System.out.println( "3.后置通知..." + jp.getSignature().getName() );
        System.out.println( "返回值:" + retValue );
    }

    @Around("myPointcut()")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println( "2.环绕通知...开启事务..." + pjp.getSignature().getName() );
        //放行
        Object retObj = pjp.proceed();
        System.out.println( "4.环绕通知....提交事务..." );
        return retObj;
    }

    @AfterThrowing(pointcut = "myPointcut()", throwing = "e")
    public void myAfterThrowing(JoinPoint jp, Throwable e) {
        System.out.println( "异常通知..." + jp.getSignature().getName() + "===" + e.getMessage() );
    }

    @After("myPointcut()")
    public void myAfter(JoinPoint jp) {
        System.out.println( "最终通知..." + jp.getSignature().getName() );
    }
}
