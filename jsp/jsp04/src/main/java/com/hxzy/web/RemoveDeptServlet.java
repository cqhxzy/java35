package com.hxzy.web;

import com.hxzy.biz.DepartmentBiz;
import com.hxzy.biz.impl.DepartmentBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeDept")
public class RemoveDeptServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String deptId = request.getParameter("deptId");

        DepartmentBiz departmentBiz = new DepartmentBizImpl();
        boolean deleteById = departmentBiz.deleteById(Integer.parseInt(deptId));

        response.setContentType("text/plain");
        response.getWriter().println(Boolean.toString(deleteById));
        response.getWriter().flush();
        response.getWriter().close();
    }
}
