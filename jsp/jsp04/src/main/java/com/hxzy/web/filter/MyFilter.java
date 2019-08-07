package com.hxzy.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(MyFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("---------------------- MyFilter init ----------------------");
        String name = filterConfig.getInitParameter("name");
        logger.debug("filter init param:" + name);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //servletRequest封装的是我们的请求对象
        //servletResponse封装的是响应的对象
        //filterChain 是过滤器链
        /*      只有一个方法doFilter（request,response）
        *   在调用doFilter方法的前后，我们就能够实现响应的逻辑操作。
        * */
        HttpServletRequest request = (HttpServletRequest) servletRequest;   //请求
        HttpServletResponse response = (HttpServletResponse) servletResponse; //响应

        String requestURI = request.getRequestURI();
        logger.debug("过滤器拦截到了" + requestURI + "的请求");

        filterChain.doFilter(request,response);  //放行

        logger.debug("请求执行完毕，开始响应客户端");
    }

    @Override
    public void destroy() {
        logger.debug("MyFilter destroy 方法被执行");
    }
}
