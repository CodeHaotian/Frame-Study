package com.ssm.study.web.controller;

import com.ssm.study.model.User1;
import com.ssm.study.model.UserExt1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author：Haotian
 * @Date：2019/5/29 22:27
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * @RequestMapping(value = "list",method = RequestMethod.POST)
     */
    @RequestMapping("/list")
    public String list(Model model) {
        //1.模拟数据库的数据
        List<User1> user1List = new ArrayList<User1>();
        User1 user1 = new User1( "李白", 20, "男", new Date() );
        User1 user12 = new User1( "杜甫", 24, "男", new Date() );
        User1 user13 = new User1( "上官", 18, "女", new Date() );

        user1.setId( 1 );
        user12.setId( 2 );
        user13.setId( 3 );
        user1List.add( user1 );
        user1List.add( user12 );
        user1List.add( user13 );

        //2.把数据存在model
        model.addAttribute( "userList", user1List );
        return "user/userlist";
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "user/register";
    }

    /**
     * 第一种接收表单参数的方式:
     * 默认日期格式 月/日/年 10/10/2016
     */
    @RequestMapping("/register")
    public String register(String username, String password,
                           int age, String gender, Date birthday,
                           String[] hobbyIds) {

        System.out.println( username );
        System.out.println( password );
        System.out.println( age );
        System.out.println( gender );
        System.out.println( birthday );
        System.out.println( Arrays.toString( hobbyIds ) );
        return "user/info";
    }

    /**
     * 第二种接收表单参数的方式:
     * 默认日期格式 月/日/年 10/10/2016
     */
    @RequestMapping("/register2")
    public String register2(User1 user1) {
        System.out.println( user1 );
        return "user/info";
    }

    /**
     * 第三种接收表单参数的方式:
     * 相当于模型里有模型
     */
    @RequestMapping("/register3")
    public String register3(UserExt1 userExt1) {
        System.out.println( userExt1 );
        return "user/info";
    }

    @RequestMapping("/register4")
    public String register4(UserExt1 userExt1) {
        System.out.println( userExt1.getUser1() );
        return "user/info";
    }

    @RequestMapping("/register5")
    public String register5(UserExt1 userExt1) {
        System.out.println( userExt1.getInfos() );
        return "user/info";
    }

    @RequestMapping("/edit")
    public String edit(int id, Model model) {
        System.out.println( "接收到修改的ID:" + id );

        //通过id,查询数据库，返回 一个User对象，把user对象存在model，假设从数据查
        User1 user1 = new User1( "李白", 20, "男", new Date() );

        user1.setId( 1 );
        model.addAttribute( "user", user1 );
        return "user/useredit";
    }

    @RequestMapping("/edit1/{id}")
    public String edit1(@PathVariable int id, Model model) {
        System.out.println( "接收到修改的ID:" + id );
        User1 user1 = new User1( "李白", 20, "男", new Date() );
        user1.setId( 1 );
        model.addAttribute( "user", user1 );
        return "user/useredit";
    }

    @RequestMapping("test1")
    public String test1() {
        //同一个控制器转发
        return "forward:list.do";
    }

}
