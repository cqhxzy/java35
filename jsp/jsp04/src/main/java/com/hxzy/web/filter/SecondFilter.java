package com.hxzy.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class SecondFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(SecondFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("---------------------- SecondFilter init ----------------------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.debug("---------------------- SecondFilter ready to doFilter ----------------------");
        filterChain.doFilter(servletRequest,servletResponse);//放行请求
        logger.debug("---------------------- SecondFilter finish doFilter ----------------------");

    }

    @Override
    public void destroy() {
        logger.debug("---------------------- SecondFilter destroy ----------------------");
    }
}
