<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/2 0002
  Time: 上午 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有用户信息</title>
    <style>
        table,td,th{
            border: 1px solid #ccc;
            border-collapse: collapse;/*合并重叠的边框*/
            width: 500px;
            margin: 0 auto;
            text-align: center;
        }

    </style>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Map<String,String>> users = (List<Map<String, String>>) request.getAttribute("users");
                System.out.println(users.size() + "-----------------------------------");
                if (users != null && users.size() > 0){
                    for (int i = 0; i < users.size(); i++) {
                        Map<String, String> map = users.get(i); //获取每条数据
            %>
                        <tr>
                            <td><%=map.get("userName")%></td>
                            <td><%=map.get("userAge")%></td>
                            <td><%=map.get("userSex")%></td>
                            <td>
                                <a href="#">编辑</a>
                                <a href="#">删除</a>
                            </td>
                        </tr>
            <%        }
                }
            %>


        </tbody>
    </table>
</body>
</html>
