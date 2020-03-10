package com.ztplab01.controllers.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/WelcomeServlet", "/DashboardServlet"}, dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class AuthenticationFilter implements Filter {
    public void destroy() {
    }

    //TODO wrong? dispacher? idea of filter?
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Redirection to AuthenticationFilter");

        if(req.getServletContext().getAttribute("com.ztplab01.LoginServlet.username") != null && req.getServletContext().getAttribute("com.ztplab01.LoginServlet.username").equals("admin")){
            System.out.println("YYYYYYYYYYYYYYYY");
            RequestDispatcher adminServletDispatcher = req.getRequestDispatcher("AdminServlet");
            adminServletDispatcher.forward(req, resp);
        }
        else{
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
