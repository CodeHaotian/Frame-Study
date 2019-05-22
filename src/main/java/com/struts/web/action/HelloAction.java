package com.struts.web.action;

/**
 * @author Haotian
 */

public class HelloAction {
    /**
     * description: 测试环境搭建
     * @return success
     */
    public String sayHello() {
        System.out.println( "HelloAction的sayHello被访问了。。。。" );
        return "success";
    }
}
