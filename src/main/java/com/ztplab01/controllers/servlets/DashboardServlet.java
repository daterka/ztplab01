package com.ztplab01.controllers.servlets;

import com.ztplab01.models.beans.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "DashboardServlet", urlPatterns = "/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Redirection to DashboardServlet POST");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<a href=\"AdminServlet\"</a>");
        ArrayList<Book> books = (ArrayList<Book>) request.getServletContext().getAttribute("com.ztplab01.LibraryListener.books");
        for (Book book: books) {
            writer.println("<h3>"+book.toString()+"</>");
        }

        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Redirection to DashboardServlet GET");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        ArrayList<Book> books = (ArrayList<Book>) request.getServletContext().getAttribute("com.ztplab01.LibraryListener.books");
        for (Book book: books) {
            writer.println("<h3>"+book.toString()+"</>");
        }

        writer.close();
    }
}
