<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<S:form action="/upload" enctype="multipart/form-data" method="POST">
    <s:textfield label="用户名" name="username"/>
    <s:password label="密码" name="password"/>
    <s:file label="照骗" name="photo"/>
    <s:submit value="点击上传"/>
</S:form>
</body>
</html>
