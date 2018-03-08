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
@WebServlet(name = "CompanyEditServlet", urlPatterns = "/view/company/edit")
public class CompanyEditServlet extends HttpServlet {
    private CompanyDB companyDB = new CompanyDB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        int d_id = request.getParameter("director_id").equals("null") ? -1 : Integer.parseInt(request.getParameter("director_id"));
        companyDB.changeRecord(Integer.parseInt(request.getParameter("id")),
                d_id,
                request.getParameter("name"),
                request.getParameter("focusarea"));
        request.setAttribute("rs", companyDB.getTable());
        request.getRequestDispatcher("companies.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("rs", companyDB.getRecord(Integer.parseInt(request.getParameter("id"))));
        request.getRequestDispatcher("edit.jsp").forward(request, response);


    }
}
