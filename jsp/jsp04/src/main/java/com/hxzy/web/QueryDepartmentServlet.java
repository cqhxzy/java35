package com.hxzy.web;

import com.hxzy.biz.DepartmentBiz;
import com.hxzy.biz.impl.DepartmentBizImpl;
import com.hxzy.entity.Department;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QueryDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //通过业务逻辑层获取后台的数据

        DepartmentBiz departmentBiz = new DepartmentBizImpl();
        List<Department> departments = departmentBiz.queryAll();

        request.setAttribute("list",departments); //将数据保存到request作用域
        // 在页面转发中的/代表了webapp这个根目录
        request.getRequestDispatcher("/QueryDepartments.jsp").forward(request,response);

    }
}
