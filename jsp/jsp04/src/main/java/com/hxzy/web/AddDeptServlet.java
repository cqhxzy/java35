package com.hxzy.web;

import com.hxzy.biz.DepartmentBiz;
import com.hxzy.biz.impl.DepartmentBizImpl;
import com.hxzy.entity.Department;
import com.hxzy.vo.AjaxResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 新增部门的servlet
 */
@WebServlet(urlPatterns = {"/addDept"})
public class AddDeptServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8"); //设置编码方式
        response.setCharacterEncoding("utf-8");

        String deptName = request.getParameter("deptName"); //获取部门名称
        String deptAddress = request.getParameter("deptAddress"); //部门地址
        System.out.println(deptName + "\t" + deptAddress);

        DepartmentBiz departmentBiz = new DepartmentBizImpl();
        Department department = new Department(deptName,deptAddress);
        boolean save = departmentBiz.save(department); //true:成功，false：失败

        //AjaxResult result = new AjaxResult(save,null);

        response.setContentType("text/plain");
        response.getWriter().println(Boolean.toString(save));//将boolean通过其包装类装换为字符串形式的true或false
        response.getWriter().flush(); //刷新缓存
        response.getWriter().close();
    }
}
