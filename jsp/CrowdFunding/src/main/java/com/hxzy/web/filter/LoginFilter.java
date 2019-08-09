package com.hxzy.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();
        if (special(requestURI)){ //特殊放行的请求
            filterChain.doFilter(request,response);
            return;
        }

        HttpSession session = request.getSession(false);
        if (session != null) {
            Object loginUser = session.getAttribute("loginUser");
            if (loginUser != null) {
                filterChain.doFilter(request,response);
                return;
            }
        }
        response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");

    }

    private boolean special(String path){//jsp04/asset/layer/theme/default/layer.css
        String[] special = {
                "/jsp/login.jsp",
                "/sys/doLogin",
                ".css",
                ".jpg",
                ".png",
                ".js",
                ".gif",
                "woff2",
                "woff",
                "ttf",
                "css.map",

        };
        for (int i = 0; i < special.length; i++) {
            if (path.endsWith(special[i])){
                return true;
            }
        }
        return false;
    }
    @Override
    public void destroy() {

    }
}
