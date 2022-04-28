package com.weilin.week5.demo;

import com.weilin.dao.UserDao;
import com.weilin.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public  void init() throws ServletException{
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        try{
            UserDao userDao=new UserDao();
            User user=userDao.findByUsernamePassword(con,username,password);
            if(user!=null){
                if(request.getParameter("rememberMe").equals("1")){
                    Cookie usernameCookie=new Cookie("cUserName",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",request.getParameter("rememberMe"));
                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }

                HttpSession session=request.getSession();
                System.out.println("session id -->"+session.getId());
                session.setMaxInactiveInterval(10);
                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }else {
                request.setAttribute("message","Username or Password Error");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        String sql="select id,username,password,email,gender,birthdate from usertable where username ='"+username+"
        try {
            ResultSet rs = null;
            try {
                rs = con.createStatement().executeQuery(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (rs.next()) {
                    request.setAttribute("id", rs.getInt("id"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {

        }
    }
}
