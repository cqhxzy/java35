<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /*
    * doQuery.jsp是一个负责查询所有用户信息的逻辑页面
    * 不负责显示数据
    * */
    List<Map<String, String>> allUsers = new ArrayList<>();

    //准备模拟数据
    Map<String,String> user1 = new HashMap(){{
        put("userName","张三1");
        put("userAge","18");
        put("userSex","男");
    }};Map<String,String> user2 = new HashMap(){{
        put("userName","张三2");
        put("userAge","18");
        put("userSex","女");
    }};Map<String,String> user3 = new HashMap(){{
        put("userName","张三3");
        put("userAge","18");
        put("userSex","女");
    }};Map<String,String> user4 = new HashMap(){{
        put("userName","张三4");
        put("userAge","18");
        put("userSex","男");
    }};

    allUsers.add(user1);
    allUsers.add(user2);
    allUsers.add(user3);
    allUsers.add(user4);


    request.setAttribute("users",allUsers); //将list集合添加到request作用域

    request.getRequestDispatcher("/allUsers.jsp").forward(request,response);
%>
