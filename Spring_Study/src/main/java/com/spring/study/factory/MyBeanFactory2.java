package com.spring.study.factory;

import com.spring.study.aspect.MyAspect2;
import com.spring.study.service.UserService;
import com.spring.study.service.impl.StudentService;
import com.spring.study.service.impl.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Haotian
 */
public class MyBeanFactory2 {

    /**
     * JDK实现代理
     *
     * @return
     */
    public static UserService createUserService() {
        //1.创建目标对象target
        UserService userService = new UserServiceImpl();

        //2.声明切面类对象
        MyAspect2 aspect = new MyAspect2();

        //3.把切面类2个方法 应用 目标类
        //3.1 创建JDK代理,拦截方法
        /*newProxyInstance(
                ClassLoader loader, 类加载器，写当类
                Class<?>[] interfaces, 接口,接口的方法会被拦截
                InvocationHandler h) 处理
                */
        UserService serviceProxy = (UserService) Proxy.newProxyInstance(
                MyBeanFactory2.class.getClassLoader(),
                userService.getClass().getInterfaces(),
                (Object proxy, Method method, Object[] args) -> {
                    //开启事务
                    aspect.before();
                    aspect.before();

                    //方法返回值是 业务方法的返回值
                    Object retObj = method.invoke( userService, args );
                    System.out.println( "拦截返回值:" + retObj );

                    //提交事务
                    aspect.after();
                    return retObj;
                }
        );
        return serviceProxy;
    }

}
