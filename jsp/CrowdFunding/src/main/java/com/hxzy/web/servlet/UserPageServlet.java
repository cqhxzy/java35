package com.hxzy.web.servlet;

import com.alibaba.fastjson.JSONObject;
import com.hxzy.biz.UsersBiz;
import com.hxzy.biz.impl.UsersBizImpl;
import com.hxzy.entity.Users;
import com.hxzy.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sys/userPage")
public class UserPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String index = request.getParameter("pageIndex");
        Integer pageIndex = Integer.parseInt(index); //获取页面传递的当前页码


        UsersBiz usersBiz = new UsersBizImpl();
        PageUtil<Users> pageUtil = new PageUtil<>();
        pageUtil.setPageIndex(pageIndex);


        PageUtil<Users> page = ((UsersBizImpl) usersBiz).page(pageUtil, null);

        String s = JSONObject.toJSONString(page);
        System.out.println(s);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(s);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
