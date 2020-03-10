package com.ztplab01.controllers.servlets;

import com.ztplab01.models.beans.User;
import com.ztplab01.models.enums.Role;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", urlPatterns = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Redirection to AdminLoginServlet POST");
        try{
            // TODO password hadrcoding + dao auth
            User admin = new User(request.getParameter("username"), request.getParameter("userpass"));
            if(admin.getLogin().equals("admin") && admin.getPassword().equals("admin")){
                admin.setRole(Role.ADMIN);
                this.getServletConfig().getServletContext().setAttribute("com.ztplab01.LoginServlet.username", admin.getLogin()); //set whole user?
//                HttpSession session = request.getSession();
//                session.setAttribute("username", admin.getLogin());
                RequestDispatcher dashboardDispatcher = request.getRequestDispatcher("DashboardServlet");
                dashboardDispatcher.forward(request, response);

            }
            else{
                response.sendRedirect("/invalidLogin.jsp");
            }
        }catch(Throwable e){
            System.out.println(e);
            response.sendRedirect("/index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Redirection to AdminLoginServlet GET");
    }
}
