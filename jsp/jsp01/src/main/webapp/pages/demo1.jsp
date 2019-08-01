<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/1 0001
  Time: 上午 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo1</title>
</head>
<body>
    <%
        /*这是java代码*/
        int sum = 0;

        for (int j = 0; j < 100; j++) {
            sum += j;
        }
    %>
    <h2>您正在访问demo1.jsp</h2>
    <div>1-100累加求和：<%=sum%></div>
</body>
</html>
