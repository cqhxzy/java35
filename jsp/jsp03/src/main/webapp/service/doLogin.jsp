<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /*
    * doLogin.jsp这个页面并不需要显示任何东西。
    * 这个jsp文件充当的作用为接收登录页面发送的请求
    * 1.从请求中获取用户提交的用户名和密码
    * 2.根据用户名和密码验证其正确性（通过JDBC从数据库查询用户名和密码是否正确）
    * 3.    如果查到了用户，则跳转到登录成功的页面
    *       如果没有查到用户，则重新回到登录页面
    *
    * */

    request.setCharacterEncoding("utf-8"); //设置请求域的编码方式

    /*
    * request.getParameter();   获取从客户端发起请求的数据
    * request.getAttribute();   从request作用域中获取数据，request作用域中的数据是通过request.setAttribute()往里添加的。
    *
    * request.getParameter(String); 从request作用域中，根据表单元素的name属性获取其值。
    *                       http://localhost:8080/jsp03/doLogin.jsp?userName=?&loginPwd=?
    * */
    String userName = request.getParameter("userName");
    String loginPwd = request.getParameter("loginPwd");

    System.out.println("用户名：" + userName + ",登录密码：" + loginPwd);
    if(userName.equals("admin") && loginPwd.equals("123456")){ //登录成功。
        //跳转到查询所有信息的页面
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("doQuery.jsp"); //获取页面转发的对象
        requestDispatcher.forward(request,response);
    } else {
        //返回登录页面
        //response.sendRedirect("../login.jsp"); //重新回到login.jsp页面中去
        String scheme = request.getScheme(); //得到协议
        String serverName = request.getServerName();//得到服务器ip地址
        int port = request.getServerPort(); //获取服务器端口号
        //String servletPath = request.getServletPath(); //获取当前被访问的servlet
        String contextPath = request.getContextPath();//获取当前的项目名

        String url = scheme + "://" + serverName + ":" + port + contextPath + "/login.jsp";
        System.out.println(url);

        response.sendRedirect(url); //重新回到login.jsp页面中去
    }
%>