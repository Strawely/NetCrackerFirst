package web;

import database.CompanyDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Роман on 03.03.2018.
 */
@WebServlet(name = "CompanySortServlet",urlPatterns = "/view/company/sort")
public class CompanySortServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        CompanyDB companyDB=new CompanyDB();
        request.setAttribute("rs",companyDB.getSortedTable(Integer.parseInt(request.getParameter("n"))));
        request.getRequestDispatcher("companies.jsp").forward(request,response);
    }
}
