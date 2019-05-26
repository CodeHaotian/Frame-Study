package com.spring.study.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.spring.study.model.Users;
import com.spring.study.service.IUserService;

/**
 * @Author：Haotian
 * @Date：2019/5/26 22:26
 */
public class IUserAction extends ActionSupport implements ModelDriven<Users> {
    private Users users = new Users();
    /**
     * 在action中使用Service注意：
     * 1.不需要在spring的配置文件中注入service
     * 2.会根据spring中的id的名字注入到当前属性中
     * 3.在action中service要提供set方法
     */

    private IUserService iUserService;

    public void setiUserService(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    public String register() {
        //获取请求参数
        System.out.println( users );

        //调用Service
        iUserService.register( users );

        //返回结果
        return SUCCESS;
    }

    @Override
    public Users getModel() {
        return users;
    }
}