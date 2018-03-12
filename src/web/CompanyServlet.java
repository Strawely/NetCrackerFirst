package web;

import database.CompanyDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Роман on 23.02.2018.
 */
@WebServlet(name = "CompanyServlet", urlPatterns = "/view/company/")
public class CompanyServlet extends HttpServlet {
    CompanyDB companyDB = new CompanyDB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("rs", companyDB.getSearchResult(Integer.parseInt(request.getParameter("col")),request.getParameter("expr")));
        request.getRequestDispatcher("companies.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("rs", companyDB.getTable());
        request.getRequestDispatcher("companies.jsp").forward(request, response);
    }
}
