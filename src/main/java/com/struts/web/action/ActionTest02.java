package com.struts.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.domain.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：Haotian
 * @Date：2019/5/20 23:18
 */
public class ActionTest02 extends ActionSupport {
    /**
     * /action提供属性，并提供get方法，这个属性数据就会被存在值栈
     */
    private List<Student> stuList;

    public List<Student> getStuList() {
        return stuList;
    }

    public String list() {

        //jsp一般从值栈取数据
        stuList = new ArrayList<Student>();
        stuList.add( new Student( "艾莉丝", 18, "2056423011@qq.com", "000", "000", 100, "yi", "男" ) );
        stuList.add( new Student( "艾莉丝", 18, "2056423011@qq.com", "000", "000", 100, "yi", "男" ) );
        stuList.add( new Student( "艾莉丝", 18, "2056423011@qq.com", "000", "000", 100, "yi", "男" ) );
        stuList.add( new Student( "艾莉丝", 18, "2056423011@qq.com", "000", "000", 100, "yi", "男" ) );
        stuList.add( new Student( "艾莉丝", 18, "2056423011@qq.com", "000", "000", 100, "yi", "男" ) );

        return SUCCESS;
    }
}
