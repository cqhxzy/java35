package com.hxzy.web.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitServletContextListener implements ServletContextListener  {
    private Logger logger = LoggerFactory.getLogger(InitServletContextListener.class);
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //当创建application对象时触发的方法
        ServletContext application = servletContextEvent.getServletContext();
        String contextPath = application.getContextPath();//获取部署的项目名
        application.setAttribute("APP_PATH",contextPath);
        logger.debug("init APP_PATH:" + contextPath);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //当销毁application对象时触发的方法
    }
}
