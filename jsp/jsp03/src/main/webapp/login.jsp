<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/2 0002
  Time: 上午 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <%
        System.out.println("进入Login.jsp页面");
    %>
</head>
<body>
    <div class="main">
        <form action="service/doLogin.jsp" method="post">
            <div>
                <label for="userName">用户名：</label>
                <input type="text" name="userName" placeholder="请输入用户名" id="userName" />
            </div>
            <div>
                <label for="loginPwd">密码：</label>
                <input type="password" name="loginPwd" placeholder="请输入密码" id="loginPwd" />
            </div>
            <div>
                <label>保存密码:<input type="checkbox" name="savePwd"/></label>
            </div>
            <div>
                <button>登录</button>
            </div>

        </form>
    </div>
</body>
</html>
