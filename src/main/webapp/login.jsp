<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login.action" method="get">
    <label for="name">用户账号：</label>
    <input type="text" id="name" name="username"><br>

    <label for="password">用户密码：</label>
    <input type="password" id="password" name="password"><br>
    <%--使用token判断，防止表单重复提交--%>
    <s:token></s:token>
    <input type="submit" value="登录">
</form>
</body>
</html>
