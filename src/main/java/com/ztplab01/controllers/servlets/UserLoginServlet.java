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
import java.util.HashMap;

@WebServlet(name = "UserLoginServlet", urlPatterns = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    private HashMap<String, String> usersAuth;

    @Override
    public void init(){
        this.usersAuth = new HashMap<String, String>();
        usersAuth.put("user", "user");
        usersAuth.put("nick", "nick");
        usersAuth.put("nickname", "password");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Redirection to UserLoginServlet POST");
        try{
            User user = new User(request.getParameter("username"), request.getParameter("userpass"));
            // TODO password hadrcoding + dao auth
            if(checkUser(user.getLogin(), user.getPassword())){
                user.setRole(Role.USER);
                request.getServletContext().setAttribute("com.ztplab01.LoginServlet.username", user.getLogin());
//                HttpSession session = request.getSession();
//                session.setAttribute("username", user.getLogin());
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

    }



    private boolean checkUser(String username, String userpassword){
        //TODO improve structure, one if? return statement with more info abount wrong username OR password
        if(this.usersAuth.containsKey(username)){
            System.out.println("CCCCCCCCCCCCCCCC");
            if(this.usersAuth.get(username).equals(userpassword)){
                System.out.println("DDDDDDDDDDDDDDDD");
                return true;
            }
            else return false;
        }
        else return false;
    }
}
