package web;

import database.FilialDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Роман on 03.03.2018.
 */
@WebServlet(name = "FilialAddServlet",urlPatterns = "/view/filial/add")
public class FilialAddServlet extends HttpServlet {
    FilialDB filialDB=new FilialDB();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        int c_id = request.getParameter("company_id").equals("null") ? -1 : Integer.parseInt(request.getParameter("company_id"));
        filialDB.addRecord(c_id,
                request.getParameter("name"));
        request.setAttribute("rs", filialDB.getTable());
        request.getRequestDispatcher("filials.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("add.jsp").forward(request, response);

    }
}
