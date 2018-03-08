package web;

import database.FilialDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Роман on 23.02.2018.
 */
@WebServlet(name = "FilialServlet",urlPatterns = "/view/filial/")
public class FilialServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        FilialDB filialDB= new FilialDB();
        request.setAttribute("rs", filialDB.getTable());
        request.getRequestDispatcher("filials.jsp").forward(request, response);
    }
}
