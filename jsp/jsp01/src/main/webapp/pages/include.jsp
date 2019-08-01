<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/1 0001
  Time: 下午 3:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Calendar instance = Calendar.getInstance();
    int year = instance.get(Calendar.YEAR);
    int month = instance.get(Calendar.MONTH) + 1;
    int date = instance.get(Calendar.DATE);

    String str = year + "年" + month + "月" + date + "日";
%>
<div style="color: red;font-weight: bold;"><%=str %></div>