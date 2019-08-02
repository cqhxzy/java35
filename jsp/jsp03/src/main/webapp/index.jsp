<%@page contentType="text/html; charset=utf-8" %>
<html>
<body>
<%
    String user = (String) session.getAttribute("user");
%>
<h2>欢迎您：<%=user%></h2>
</body>
</html>
