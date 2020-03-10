package com.ztplab01.controllers.servlets;

import com.ztplab01.models.beans.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

@WebServlet(name = "AdminServlet", urlPatterns = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Redirection to AdminServlet POST");
        PrintWriter writer = response.getWriter();
        writer.println("<h1> AdminServlet </h1>");

        writer.println("<ul>");
        for (Book book: (ArrayList<Book>)this.getServletConfig().getServletContext().getAttribute("com.ztplab01.LibraryListener.books")) {
//            writer.println("<li><h3>" + book.toString() + "</h3><button>delete</button></li>");
            writer.println("<li><h3>" + book.toString() + "</h3><a href=\"/AdminServlet?id="+ book.getId() + "\">Delete</a></li>");
        }
        writer.println("</ul>");

        writer.println("<form action=\"AddBookServlet\" method=\"POST\">");
        writer.println("title : <input type=\"text\" name=\"title\"<br/><br/>");
        writer.println("author : <input type=\"text\" name=\"author\"<br/><br/>");
        writer.println("released date : <input type=\"text\" name=\"released\"<br/><br/>");
        writer.println("genre : <input type=\"text\" name=\"genre\"<br/><br/>");
        writer.println("<input type=\"submit\" value=\"Add\">");

        writer.println("</form>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Redirection to AdminServlet GET");
        PrintWriter writer = response.getWriter();
        writer.println("<h1> AdminServlet </h1>");

        writer.println("<ul>");
        for (Book book: (ArrayList<Book>)this.getServletConfig().getServletContext().getAttribute("com.ztplab01.LibraryListener.books")) {
//            writer.println("<li><h3>" + book.toString() + "</h3><button>delete</button></li>");
            writer.println("<li><h3>" + book.toString() + "</h3><a href=\"/delete?id="+ book.getId() + "\">Delete</a></li>");
        }
        writer.println("</ul>");

        writer.println("<form action=\"AddBookServlet\" method=\"POST\">");
        writer.println("title : <input type=\"text\" name=\"title\"<br/><br/>");
        writer.println("author : <input type=\"text\" name=\"author\"<br/><br/>");
        writer.println("released date : <input type=\"text\" name=\"released\"<br/><br/>");
        writer.println("genre : <input type=\"text\" name=\"genre\"<br/><br/>");
        writer.println("<input type=\"submit\" value=\"Add\">");

        writer.println("</form>");

    }
}
