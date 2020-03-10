package com.ztplab01.controllers.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WelcomeServlet", urlPatterns = "/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("Redirection to WelcomeServlet POST");
//        if(getServletContext().getAttribute("username") != null){
//            response.sendRedirect("DashboardServlet");
//        }
//        else {
//            response.sendRedirect("/login.jsp");
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Redirection to WelcomeServlet GET");
        if(this.getServletConfig().getServletContext().getAttribute("com.ztplab01.LoginServlet.username") != null){
            //TODO check all redirection and change to dispachers if is needed
            //response.sendRedirect("DashboardServlet");
            RequestDispatcher dashboardServletDispatcher = request.getRequestDispatcher("DashboardServlet");
            dashboardServletDispatcher.forward(request, response);
        }
        else {
            response.sendRedirect("/login.jsp");
        }
    }
}
