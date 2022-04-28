package com.weilin.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FrontEndAuthenticationFilter implements Filter {
    private HttpServletRequest httpServletRequest;
    private static final String[] loginrequiredURLs= {
            "/updateUser","/logout","/myCart"
    };
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        throw IOException,ServletException{
            httpServletRequest=(HttpServletRequest) servletRequest;

            String path =httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());

            if(path.startsWith("/admin")){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
            HttpSession session=httpServletRequest.getSession(false);
            boolean isLoggedIn =(session !=null&&session.getAttribute("userList")!=null);
            String loginURI=httpServletRequest.getContextPath() +"/login";
            boolean isLoginRequest =httpServletRequest.getRequestURI().equals(loginURI);
            boolean isLoginPage =httpServletRequest.getRequestURI().endsWith("login");

            if(isLoggedIn && (isLoginRequest || isLoginPage)) {
                httpServletRequest.getRequestDispatcher("/").forward(servletRequest,servletResponse);
            }else if(!isLoggedIn && isLoginRequird()){
                String loginPage = "/login";
                RequestDispatcher dispatcher =httpServletRequest.getRequestDispatcher(loginPage);
                dispatcher.forward(servletRequest.servletResponse);
            }else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }
    private boolean isLoginRequird(){
        String requestURL = httpServletRequest.getRequestURI().toString();

        for (String loginRequiredURL : loginrequiredURLs){
            if (requestURL.contains(loginRequiredURL)){
                return  true;
            }
        }
        return false;
    }
    @Override
    public void destroy() {

    }

}
