package com.ztplab01.controllers.servlets;

import com.ztplab01.models.beans.Book;
import com.ztplab01.models.beans.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "AddBookServlet", value = "/AddBookServlet")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Redirection to AddBookServlet");
        String title = (String) request.getParameter("title");
        String author = (String) request.getParameter("author");
        String releasedDate = (String) request.getParameter("released");
        String genre = (String) request.getParameter("genre");

        System.out.println(title + author + releasedDate + genre);

        ArrayList<Book> books;
        if((books = (ArrayList<Book>)this.getServletConfig().getServletContext().getAttribute("com.ztplab01.LibraryListener.books")) != null){
            int id = books.get(books.size()-1).getId();
            Book book = new Book(id+1, title, author, releasedDate, genre);
            System.out.println(id + title + author + releasedDate + genre);
            books.add(book);
            System.out.println("Book added to existing collection");
        }
        else{
            Book book = new Book(0, title, author, releasedDate, genre);
            books.add(book);
            System.out.println("Book added to new collection");
        }

        RequestDispatcher adminServletDispatcher = request.getRequestDispatcher("AdminServlet");
        adminServletDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
