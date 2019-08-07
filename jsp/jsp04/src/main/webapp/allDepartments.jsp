<%@ page import="com.hxzy.biz.DepartmentBiz" %>
<%@ page import="com.hxzy.biz.impl.DepartmentBizImpl" %>
<%@ page import="com.hxzy.entity.Department" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/5 0005
  Time: 下午 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有部门信息</title>
    <style>
        table{
            width: 500px;
            margin: 0 auto;
        }
        table,td,th{
            border: 1px solid #000;
            border-collapse: collapse;/*重叠邻近的边框*/
            text-align: center;
        }
    </style>
</head>
<body>
    <%
        DepartmentBiz departmentBiz = new DepartmentBizImpl();
        List<Department> departments = departmentBiz.queryAll();
    %>
    <table>
        <thead>
            <tr>
                <th><input type="checkbox" id="all" />全选</th>
                <th>部门名称</th>
                <th>部门地址</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (int i = 0; i < departments.size(); i++) {
                    Department department = departments.get(i);

            %>
                <tr>
                    <td><input type="checkbox" name="deptId" value="<%=department.getDeptId()%>" /></td>
                    <td><%=department.getDeptName()%></td>
                    <td><%=department.getDeptAddress()%></td>
                    <td>
                        <a href="#">修改</a>
                        <a href="#">删除</a>
                    </td>
                </tr>
            <%    }
            %>
        </tbody>
    </table>
</body>
</html>
