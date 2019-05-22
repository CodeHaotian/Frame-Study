<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加用户</title>
    <s:head></s:head>
</head>
<body>

<hr>
<s:debug></s:debug>
添加学生
<s:actionerror/>
<s:form action="/stu/add.action">
    <s:textfield name="username" label="用户名"/>
    <s:textfield name="age" label="年龄"/>
    <s:textfield name="email" label="邮箱"/>
    <s:textfield name="password" label="密码"/>
    <s:textfield name="repassword" label="确认密码"/>
    <s:textfield name="score" label="成绩"/>
    <s:textfield name="url" label="个人主页"/>
    <s:radio list="{'男','女'}" name="gender" label="性别"></s:radio>
    <s:submit value="提交"/>
</s:form>
</body>
</html>