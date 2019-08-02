<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    //验证用户是否登录
    String userInfo = (String) session.getAttribute("user");//从session获取用户信息
    if (userInfo == null){ //没有登录
        Cookie[] cookies = request.getCookies();  //从请求中获取缓存
        String userName = null;
        String loginPwd = null;
        if(cookies == null) {  //如果没有缓存，说明第一次打开页面，没有登录
            response.sendRedirect("../login.jsp"); //跳转到登录页面
            return;
        }

        for (int i = 0; i < cookies.length; i++) {  //从cookie中读取用户名和密码
            String name = cookies[i].getName();
            if (name.equals("userName")){
                userName = cookies[i].getValue();
            } else if (name.equals("loginPwd")) {
                loginPwd = cookies[i].getValue();
            }
        }

        if (userName != null && loginPwd != null) { //验证用户名和密码是否为空
            if(userName.equals("admin") && loginPwd.equals("123456")){ //登录成功。
                session.setAttribute("user","admin");//登录成功后，将用户名保存到session作用域中
            }
        } else {
            response.sendRedirect("../login.jsp");
            return;
        }
    }


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

    request.getRequestDispatcher("/allUsers.jsp").forward(request,response); //页面转发
%>
