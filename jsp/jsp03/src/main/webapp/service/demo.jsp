
<%
    //分别向四大作用域中存放数据
    request.setAttribute("requestScope","request");
    session.setAttribute("sessionScope","session");
    application.setAttribute("applicationScope","application");


    request.getRequestDispatcher("/service/demo2.jsp").forward(request,response);//页面转发

%>

