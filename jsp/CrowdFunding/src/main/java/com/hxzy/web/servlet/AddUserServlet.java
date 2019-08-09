package com.hxzy.web.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hxzy.biz.UsersBiz;
import com.hxzy.biz.impl.UsersBizImpl;
import com.hxzy.entity.Users;
import com.hxzy.vo.AjaxResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/sys/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String loginName = request.getParameter("loginName");
        String userName = request.getParameter("userName");
        String loginPwd = request.getParameter("loginPwd");
        String email = request.getParameter("email");

        Users users = new Users(0, loginName,loginPwd, userName,email, new Date());

        UsersBiz usersBiz = new UsersBizImpl();
        boolean save = usersBiz.save(users);

        AjaxResult result = new AjaxResult();
        result.setSuccess(save);

        String jsonString = JSONObject.toJSONString(result);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(jsonString);
        response.getWriter().flush();
        response.getWriter().close();

    }
}
