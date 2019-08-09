package com.hxzy.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sys/logOut")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //清空session
        HttpSession session = request.getSession();
        session.invalidate(); //使session立即失效
        String app_path = request.getContextPath();
        response.sendRedirect(app_path + "/jsp/login.jsp"); //因为这个url路径要响应给客户端，客户端中/代表的tomcat中的webapps目录

    }
}
