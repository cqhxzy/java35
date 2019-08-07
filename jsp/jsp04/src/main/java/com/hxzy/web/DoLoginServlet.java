package com.hxzy.web;

import com.alibaba.fastjson.JSONObject;
import com.hxzy.biz.UserInfoBiz;
import com.hxzy.biz.impl.UserInfoBizImpl;
import com.hxzy.entity.UserInfo;
import com.hxzy.vo.AjaxResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/admin/doLogin")
public class DoLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginName = request.getParameter("loginName");
        String loginPwd = request.getParameter("loginPwd");

        response.setCharacterEncoding("utf-8");

        UserInfoBiz userInfoBiz = new UserInfoBizImpl();
        UserInfo login = userInfoBiz.login(loginName, loginPwd); //根据用户名和密码查询用户

        AjaxResult result = new AjaxResult();

        if (login != null) {
            //登录成功
            result.setFlag(true);
            /*
            * request.getSession()    获取session，如果服务器中没有对应的session对象则新建一个
            * request.getSession(false)  获取session，如果服务器中没有对应的session，则返回null
            * */
            HttpSession session = request.getSession();
            session.setAttribute("loginUser",login);  //将用户信息保存到session
        } else {
            //用户名或密码错误
            result.setFlag(false);
            result.setData("用户名或密码错误！");
        }

        //将java对象AjaxResult转换为json字符串输出给客户端。

        String jsonString = JSONObject.toJSONString(result);

        response.setContentType("application/json");
        response.getWriter().println(jsonString);
        response.getWriter().flush();
        response.getWriter().close();

    }
}
