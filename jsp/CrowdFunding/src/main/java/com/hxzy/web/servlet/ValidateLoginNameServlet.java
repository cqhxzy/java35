package com.hxzy.web.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hxzy.biz.UsersBiz;
import com.hxzy.biz.impl.UsersBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/sys/validateLoginName")
public class ValidateLoginNameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginName = request.getParameter("loginName");

        UsersBiz usersBiz = new UsersBizImpl();
        boolean validateLoginName = usersBiz.validateLoginName(loginName);

        Map map = new HashMap();
        map.put("valid", validateLoginName);

        String jsonString = JSONObject.toJSONString(map);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(jsonString);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
