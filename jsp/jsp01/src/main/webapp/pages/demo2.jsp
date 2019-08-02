<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/1 0001
  Time: 下午 3:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo2</title>

</head>
<body>
    <%
        /*这个范围内编写java代码*/
        Date date = new Date();
    %>
    <h2>demo2.jsp</h2>
    <%--<%@include file="include.jsp"%>--%>  <!--在本页面中包含include.jsp文件,静态包含-->
    <jsp:include page="include.jsp"/>  <!--动态包含-->
</body>
</html>
