<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>取数据</title>
</head>
<body>
<table border="1">
    <tr>
        <td>状态</td>
        <td>名字</td>
        <td>年龄</td>
        <td>城市</td>
    </tr>
    <!-- 使用struts的遍历标签
         1.value:写值栈变量名
         2.var:遍历的变量名,存到contextMap
         2.status:遍历的状态
    -->
    <s:iterator value="stuList.{?#this.age>=18}" var="stu" status="st">
        <tr>
            <td>${st.count} </td>
            <td><s:property value="#stu.username"/></td>
            <td><s:property value="#stu.age"/></td>
            <td><s:property value="#stu.email"/></td>
        </tr>
    </s:iterator>
    <%--   <s:iterator value="stuList.{name}" var="stu" status="st">
           <tr>
               <td>${st.count} </td>
               <td><s:property value="#stu"/></td>
               <td></td>
               <td></td>
           </tr>
       </s:iterator>--%>
</table>

<s:debug></s:debug>
</body>
</html>
