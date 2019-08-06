package com.hxzy.web;

import com.hxzy.biz.DepartmentBiz;
import com.hxzy.biz.impl.DepartmentBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/batchRemoveDept")
public class BatchRemoveDeptServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String deptIds = request.getParameter("deptIds");
        String[] split = deptIds.split("\\|"); //所有被删除的id

        DepartmentBiz departmentBiz = new DepartmentBizImpl();
        boolean batchRemoveDept = departmentBiz.batchRemoveDept(split);

        response.setContentType("text/plain");
        response.getWriter().println(Boolean.toString(batchRemoveDept));
        response.getWriter().flush();
        response.getWriter().close();
    }
}
