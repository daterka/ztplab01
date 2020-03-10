package com.ztplab01.controllers.servlets;

import com.ztplab01.models.beans.User;
import com.ztplab01.models.beans.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Redirection to LoginServlet POST");
        try{
            String username = request.getParameter("username");
            System.out.println("Attempt of login with login : " + username);

            if(username.equals("admin")){
                RequestDispatcher adminDispatcher = request.getRequestDispatcher("/AdminLoginServlet");
                adminDispatcher.forward(request, response);
            }
            else{
                RequestDispatcher userDispatcher = request.getRequestDispatcher("/UserLoginServlet");
                userDispatcher.forward(request, response);
            }
        }catch(Throwable theException){
            System.out.println(theException);
            response.sendRedirect("/index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
