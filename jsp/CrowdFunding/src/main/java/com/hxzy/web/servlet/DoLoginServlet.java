package com.hxzy.web.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hxzy.biz.UsersBiz;
import com.hxzy.biz.impl.UsersBizImpl;
import com.hxzy.entity.Users;
import com.hxzy.vo.AjaxResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sys/doLogin")
public class DoLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String loginName = request.getParameter("loginName");
        String loginPwd = request.getParameter("loginPwd");
        String remember_me = request.getParameter("remember_me");

        boolean b = Boolean.parseBoolean(remember_me);

        UsersBiz usersBiz = new UsersBizImpl();
        Users login = usersBiz.login(loginName, loginPwd);
        //组建AjaxResult对象
        AjaxResult result = new AjaxResult();
        if (login != null) {

            //将登录成功的用户保存到session
            request.getSession().setAttribute("loginUser",login);

            //再处理缓存
            if (b) {
                Cookie cookie_name = new Cookie("loginName", loginName);
                cookie_name.setMaxAge(60 * 60 * 24 * 7); //缓存7天

                Cookie cookie_pwd = new Cookie("loginName", loginName);
                cookie_pwd.setMaxAge(60 * 60 * 24 * 7); //缓存7天

                response.addCookie(cookie_name);
                response.addCookie(cookie_pwd);
            }

            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }


        //通过fastjson将java对象转换为json字符串
        String s = JSONObject.toJSONString(result);

        response.setContentType("application/json");
        response.getWriter().println(s);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
