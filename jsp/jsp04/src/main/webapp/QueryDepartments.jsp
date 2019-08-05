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
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

            <!--
                c:forEach  是JSTL标准标签库中提供一种用于遍历数据一种标签库
                JSTL可以和EL表达式无缝衔接，一起使用

                item:要遍历的集合    $list 通过el表达式从4大作用域中获取数据
                var：集合每次循环时的临时变量

                通过el表达式来获取对象中的属性时，直接通过对象名.属性名就行了
            -->
            <c:forEach items="${list}" var="department">
                <tr>
                    <td><input type="checkbox" name="deptId" value="${department.deptId}" /></td>
                    <td>${department.deptName}</td>
                    <td>${department.deptAddress}</td>
                    <td>
                        <a href="#">修改</a>
                        <a href="#">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
</body>
</html>
