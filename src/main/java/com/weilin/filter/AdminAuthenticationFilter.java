package com.weilin.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
@WebListener("/admin/*")
public class AdminAuthenticationFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("userList") != null);
        String loginIn = httpServletRequest.getContextPath() + "/admin/login";
        boolean isLoggedInRequest = httpServletRequest.getRequestURI().equals("login");
        if (isLoggedIn && (isLoggedInRequest || isLogginpage)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/home");
            dispatcher.forward(request, response);
        } else if (isLoggedIn || isLoggedInRequest) {
            chain.doFilter(request, response);
        } else {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/admin/login");
        }

    }
    public void destroy(){

    }
    public void init(FilterConfig fConfig) throws  ServletException{ }
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
