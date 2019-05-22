package com.struts.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author：Haotian
 * @Date：2019/5/20 22:19
 */
public class ActionTest01 extends ActionSupport {
    @Override
    public String execute() throws Exception {
        //往cotextMap存数据
        //1.获取ActionContext
        ActionContext contextMap = ActionContext.getContext();

        //2.往cotextMap存数据
        contextMap.put( "username", "admin" );
        contextMap.put( "password", "123" );

        //3.往cotextMap的session存数据
        Map<String, Object> sessionMap = contextMap.getSession();
        //也可以通过 HttpSession httpSession = ServletActionContext.getRequest().getSession();
        sessionMap.put( "username", "admin" );
        sessionMap.put( "password", "123" );

        //4.往cotextMap的request存数据
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute( "username", "admin" );

        //5.往cotextMap的application存数据
        //application = ServletContext 【ServletActionContext.getServletContext()】
        Map<String, Object> applicationMap = contextMap.getApplication();
        applicationMap.put( "username", "admin" );

        return SUCCESS;
    }
}
