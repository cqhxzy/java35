<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/1 0001
  Time: 下午 4:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request</title>
</head>
<body>
    <h2>request内置对象</h2>
    <%
        Enumeration<String> headerNames = request.getHeaderNames();
        System.out.println("获取请求头信息");
        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            String header = request.getHeader(s);
            System.out.println(s + ":" + header);
        }
        System.out.println("\n");

        String method = request.getMethod();//获取请求方式
        System.out.println("请求方式：" + method + "\n");

        System.out.println("pageInfo:" + request.getPathInfo());
        System.out.println("contextPath:" + request.getContextPath()); //获取项目名
        System.out.println("请求参数：" + request.getQueryString()); //获取所有的用户提交的参数
        System.out.println("获取name参数的值：" + request.getParameter("name")); //获取具体某个参数，name是指用户传递参数名
        System.out.println("getRequestURI:" + request.getRequestURI());
        System.out.println("getServletPath:" + request.getServletPath());

        System.out.println(request.getProtocol()); //获取http协议版本  HTTP/1.1
        System.out.println(request.getScheme()); //获取协议  http
        System.out.println(request.getServerName());
        System.out.println(request.getServerPort());
    %>
</body>
</html>
