package com.struts.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.struts.domain.User;
import org.apache.struts2.ServletActionContext;

/**
 * 自定义拦截器类
 *
 * @Author：Haotian
 * @Date：2019/5/19 15:35
 */
public class MyInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        //1.获取session中的user
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute( "user" );
        //2.判断
        if (user != null) {
            //3.放行
            return invocation.invoke();
        }
        //4.未登录，返回登录页面
        return "toLoginPage";
    }
}
