package com.ztplab01.controllers.filters;

import com.ztplab01.models.beans.Book;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter(filterName = "DeleteBookFilter", value = "/delete")
public class DeleteBookFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Redirection to DeleteBookFilter");
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        ArrayList<Book> books = (ArrayList<Book>) req.getServletContext().getAttribute("com.ztplab01.LibraryListener.books");
        for (Book b: books) {
            System.out.println("id = " + id + " book_id = " + b.getId());
            if(b.getId() == id){
                books.remove(b);
            }
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("AdminServlet");
        requestDispatcher.forward(req, resp);
        //TODO probably wrongly used dispathcer
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
