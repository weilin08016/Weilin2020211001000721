package com.weilin.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Hello Client");
    }
    public void dopost(HttpServletRequest request , HttpServletResponse response){

    }
}
