package com.hxzy.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class LoginFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    /*
     * 注解不能够非常方便像web.xml一样配置filter的执行顺序
     * 使用注解的filter执行顺序是根据其名字定义的
     *   LoginFilter0总是要比LoginFilter1先执行
     * */

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();//获取请求的url地址
        logger.info("requestURI:" + requestURI);

        if (this.special(requestURI)){ //登录，放行
            filterChain.doFilter(request,response);
            return;
        } else { //除了登录外的请他请求，应该验证登录
            HttpSession session = request.getSession(false);
            if (session != null) {
                Object loginUser = session.getAttribute("loginUser");
                if (loginUser != null) { //登录了
                    filterChain.doFilter(request,response);
                    return;
                }
            }
            String contextPath = request.getContextPath(); //获取项目名
            //没登录
            response.sendRedirect( contextPath + "/login.jsp");
        }

    }

    @Override
    public void destroy() {

    }

    private boolean special(String path){//jsp04/asset/layer/theme/default/layer.css
        String[] special = {"login.jsp","doLogin",".css",".jpg",".png",".js",".gif"};
        for (int i = 0; i < special.length; i++) {
            if (path.endsWith(special[i])){
                return true;
            }
        }
        return false;
    }

}
