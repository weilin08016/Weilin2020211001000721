package com.weilin.week4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "JDBCemoServlet", value = "/JDBCemoServlet")
public class JDBCemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String driver="";
        String url="";
        String username="";
        String password="";
    }

  try{
      Class.forName(driver);
        Connection con= DriverManager.getConnection(url,username,password);
        System.out.println("Connection --> "+con);
    }catch(ClassNotFoundException | SQLException e){
      e.printStackTrace();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
