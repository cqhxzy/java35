package com.hxyz.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("servlet执行init初始化方法");
    }
}
