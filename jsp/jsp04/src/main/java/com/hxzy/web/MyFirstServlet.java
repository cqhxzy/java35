package com.hxzy.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * 自定义的servlet
 */
public class MyFirstServlet extends HttpServlet {
    private int i = 10;

  /*  @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
        System.out.println("得到客户端发其的请求，执行servlet的service方法" + i--);
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");//设置响应的MIME类型，给浏览器用的
        response.setCharacterEncoding("utf-8"); //设置响应的编码方式为utf-8

        PrintWriter out = response.getWriter(); //通过response得到响应的输出流。

        out.println("<html>");
        out.println("<head>");
        out.println("<title>");
        out.println("这是通过servlet打印出来的一个页面");
        out.println("</title>");
        out.println("</head>");
        out.println("<body>");


        int sum = 0;
        for (int j = 1; j <= 100; j++) {
            sum += j;
        }
        out.println("<h2 style='color:red;'>1-100累加求和：");
        out.println(sum);
        out.println("</h2>");

        out.println("</body>");

        out.println("</html>");

        out.flush(); //刷新缓存
        out.close();

    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("servlet执行destroy销毁的方法");
    }

    /*@Override
    public void init() throws ServletException {
        super.init();
        System.out.println("servlet执行init初始化方法");
    }*/

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("执行servlet初始化init方法");
        String servletName = config.getServletName();
        System.out.println("servletName:" + servletName);

        ServletContext application = config.getServletContext();//获取servlet上下文环境，它就是jsp内置对象中的application

        System.out.println("--------------------根据init-param参数中的name获取其值-----------------------------");
        String encoding = config.getInitParameter("encoding");//根据键获取servlet初始化参数
        System.out.println("初始化参数encoding：" + encoding);

        System.out.println("-----------------获取所有的初始化参数名---------------------");
        Enumeration<String> initParameterNames = config.getInitParameterNames();//获取所有的初始化参数的名称
        while (initParameterNames.hasMoreElements()) {
            String key = initParameterNames.nextElement();
            System.out.println("key：" + key);
        }
    }
}
