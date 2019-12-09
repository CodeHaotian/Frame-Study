package com.spring.demo.interceptor;

import com.spring.demo.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: Haotian
 * @Date: 2019/12/9 19:50
 * @Description: 权限拦截
 */
public class PrivilegeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断用户是否登录  本质：判断session中有没有user
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute( "user" );
        if (user == null) {
            //没有登录。拦截请求跳转登录界面
            response.sendRedirect( request.getContextPath() + "/login.jsp" );
            return false;
        }
        //有信息，放行
        return true;
    }
}
