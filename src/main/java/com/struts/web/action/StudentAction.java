package com.struts.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts.domain.Student;

/**
 * @Author：Haotian
 * @Date：2019/5/18 21:45
 */
public class StudentAction extends ActionSupport implements ModelDriven<Student> {
    private Student stu = new Student();

    @Override
    public Student getModel() {
        return stu;
    }

    public String add() {
        System.out.println( stu );
        return NONE;
    }
}
