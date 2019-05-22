package com.hibernate.utils;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate工具类
 *
 * @Author：Haotian
 * @Date：2019/5/21 21:31
 */
public class HibernateUtils {
    private static SessionFactory factory;

    static {
        //1.获取核心 配置文件对象
        Configuration cfg = new Configuration().configure();

        //2.创建会话工厂
        factory = cfg.buildSessionFactory();

        //监听程序关闭
        Runtime.getRuntime().addShutdownHook( new Thread( () -> {
            //关闭会话工厂
            factory.close();
            System.out.println( "程序关闭..." );
        } ) );
    }

    public static Session openSession() {
        return factory.openSession();
    }

    public static Session getCurrentSession() {
        return factory.getCurrentSession();
    }
}
