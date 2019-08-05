<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.hxzy.entity.Department" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/5 0005
  Time: 下午 3:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>测试el表达式</title>
</head>
<body>
    <%
        //在当前页的作用域中添加一些数据
        Department department = new Department(10,"市场部","神龙岛");
        pageContext.setAttribute("dept",department);

        pageContext.setAttribute("key","pageKey"); //将key保存到page作用域
        request.setAttribute("key","requestKey"); //将key保存到request作用域
        session.setAttribute("key","sessionKey"); //将key保存到session作用域
        application.setAttribute("key","applicationKey"); //将key保存到application作用域

    %>

    <div>java小脚本：<%=((Department)pageContext.getAttribute("dept")).getDeptName()%></div>
    <div>el表达式：${dept.deptName}</div>

    <h2>
        KEY:${key}
    </h2>
    <h2>pageScope:${pageScope.key}</h2> <!--指定从page作用域取key-->
    <h2>requestScope:${requestScope.key}</h2> <!--指定从request作用域取key-->
    <h2>sessionScope:${sessionScope.key}</h2> <!--指定从request作用域取key-->
    <h2>applicationScope:${applicationScope.key}</h2> <!--指定从request作用域取key-->
</body>
</html>
