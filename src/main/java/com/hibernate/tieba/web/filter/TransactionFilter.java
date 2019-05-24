package com.hibernate.tieba.web.filter;

import com.hibernate.utils.HibernateUtils;
import org.hibernate.Session;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author：Haotian
 * @Date：2019/5/24 16:18
 */
public class TransactionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //1.开启事务
        Session session = HibernateUtils.getCurrentSession();
        session.beginTransaction();
        try {
            //2.放行
            filterChain.doFilter( request, response );
            if (session != null && session.isOpen()) {
                //3.提交事务
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            //异常进行回滚
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
