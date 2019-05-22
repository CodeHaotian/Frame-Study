package com.struts.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts.domain.User;
import com.struts.service.UserService;
import com.struts.service.impl.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author：Haotian
 * @Date：2019/5/17 23:02
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();

    /**
     * Struts2自带表单验证
     * 第一种：重写validate方法，如果数据不对，可以往FieldError添加字段错误提示信息
     * 注意：
     * 1.表单一定要用struts的标签：s:from/s:textfield等
     * 2.addFieldError里面的key,是表单的name值
     * 3.validate对于Action来说是全局的，也就是action的所有方法都会失效
     * 4.在不需要验证的action方法上，可以声明一个注解@SkipValidation,忽略验证
     * <p>
     * 第二种：写一个方法，格式validate+方法名(第一个字母大写):validateRegister()
     * 1.只针对方法有效，是一个局部字段校验
     */
    @Override
    public void validate() {
        //判断用户名是否为空if(username == null && "".equals(username))
        if (StringUtils.isEmpty( user.getUsername() )) {
            addFieldError( "username", "用户名不能为空" );
        }
    }

    public String register() {
        /**
         * 1.struts2在使用模型驱动注入参数时，会自动类型转化
         * 2.servlet接收到表单的参数都是字符串类型
         * 3.struts2会把string类型自动转化为Date.boolean类型等
         * 4.如果是checkbox表单，会以, 拼接字符串【hobby=旅游, 编码, married=true】
         */
        System.out.println( user );

        /*调用业务方法*/
        UserService service = new UserServiceImpl();
        service.register( user );
        return NONE;
    }

    @Override
    public User getModel() {
        return user;
    }
}
