<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>注册页面</title>
    <s:head></s:head>
</head>
<body>
<%--Struts2的错误回显标签
<s:fielderror></s:fielderror>--%>
Struts2的Form标签<br>
<s:form action="/user/register.action">
    <!--
    requiredLabel:代表必填项目
    requiredPosition:必填的*号位置
    showPassword:回显时，密码还在
    -->
    <s:textfield name="username" label="用户名" requiredLabel="true" requiredPosition="left"></s:textfield>
    <s:password name="password" label="密码" showPassword="true"></s:password>
    <s:textfield name="birthday" label="生日"></s:textfield>
    <%--list使用的OGNL表达式--%>
    <s:checkboxlist list="# {'旅游':'旅游','编码':'编码','吃喝':'吃喝'}" label="爱好" name="hobby"></s:checkboxlist>
    <s:radio list="# {'true':'已婚','false':'未婚'}" label="婚姻状态" name="married"></s:radio>
    <s:submit value="注册"></s:submit>
</s:form>

<hr>
HTML的原始Form标签<br>
<form action="${pageContext.request.contextPath}/user/register.action" method="get">
    <label for="name">用户账号：</label>
    <input type="text" id="name" name="username"><br>

    <label for="password">用户密码：</label>
    <input type="password" id="password" name="password"><br>

    <label for="date">生日：</label>
    <input type="text" id="date" name="birthday"><br>

    爱好：<input type="checkbox" name="hobby" value="旅游" checked="checked">旅游<br>
    <input type="checkbox" name="hobby" value="编码">编码<br>
    <input type="checkbox" name="hobby" value="吃喝">吃喝<br>

    是否已婚： <input type="radio" name="married" value="true">已婚
    <input type="radio" name="married" value="false" checked="checked">未婚<br>

    <input type="submit" value="注册">
</form>
</body>
</html>
