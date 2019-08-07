
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String requestScope = (String) request.getAttribute("requestScope");//从request作用域中取数据
        String sessionScope = (String) session.getAttribute("sessionScope");
        String applicationScope = (String) application.getAttribute("applicationScope");


    %>

    <h2>requestScope:<%=requestScope%></h2>
    <h2>sessionScope:<%=sessionScope%></h2>
    <h2>applicationScope:<%=applicationScope%></h2>
</body>
</html>
