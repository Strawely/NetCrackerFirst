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
@WebServlet(name = "CompanyDelServlet", urlPatterns = "/view/company/delete")
public class CompanyDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        CompanyDB companyDB=new CompanyDB();
        companyDB.removeByID(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("rs",companyDB.getTable());
        request.getRequestDispatcher("companies.jsp").forward(request,response);
    }
}
