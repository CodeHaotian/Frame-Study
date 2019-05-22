package com.struts.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts.domain.User;
import lombok.Setter;
import org.apache.struts2.ServletActionContext;

/**
 * @Author：Haotian
 * @Date：2019/5/19 16:16
 */
public class LoginAction extends ActionSupport implements ModelDriven<User> {
    /**
     * 使用模型驱动接收参数
     */
    private User user = new User();
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    @Setter
    private String token;

    public String login() {
        //判断是否登录成功
        if (USERNAME.equals( user.getUsername() ) && PASSWORD.equals( user.getPassword() )) {
            //登录成功，将user保存到session中
            ServletActionContext.getRequest().getSession().setAttribute( "user", user );
            System.out.println( user );
            return SUCCESS;
        }
        return NONE;
    }

    @Override
    public User getModel() {
        return user;
    }
}
