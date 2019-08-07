package com.hxzy.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class FirstFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(FirstFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext application = filterConfig.getServletContext();
        String app_path = application.getContextPath();//获取部署的项目名
        application.setAttribute("APP_PATH",app_path);

        logger.debug("---------------------- FirstFilter init ----------------------");
        logger.debug("add app_path< " + app_path + "> to application area");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.debug("---------------------- FirstFilter ready to doFilter ----------------------");
        filterChain.doFilter(servletRequest,servletResponse);//放行请求
        logger.debug("---------------------- FirstFilter finish doFilter ----------------------");

    }

    @Override
    public void destroy() {
        logger.debug("---------------------- FirstFilter destroy ----------------------");
    }
}
