package com.struts.web.result;

import com.opensymphony.xwork2.ActionInvocation;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.result.StrutsResultSupport;

import javax.servlet.http.HttpServletResponse;


/**
 * @Author：Haotian
 * @Date：2019/5/17 16:57
 */
public class CaptchaResult extends StrutsResultSupport {
    /**
     * description: 自定义一个struts2返回类型
     *
     * @param s
     * @param actionInvocation
     * @return void
     */
    @Override
    protected void doExecute(String s, ActionInvocation actionInvocation) throws Exception {
        /*1.设置一句话*/
        s = "Picture Loading Successfully";
        /*2.获取response对象*/
        HttpServletResponse response = ServletActionContext.getResponse();
        /*3.获取response对象中的write输出流，向页面写数据*/
        response.getWriter().write( s );
    }
}
