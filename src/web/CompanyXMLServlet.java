package web;

import Beans.Company;
import database.DBUtil;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Роман on 12.04.2018.
 */
@WebServlet(name = "CompanyXMLServlet", urlPatterns = "/view/company/xml")
public class CompanyXMLServlet extends HttpServlet {
    @EJB
    Company company = (Company) DBUtil.lookUp("Company");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        company.importFromXML(Integer.parseInt(request.getParameter("file").split("\\.")[0]));
        response.sendRedirect("/view/company/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        company.convertToXML(Integer.parseInt(request.getParameter("saveID")));
        response.sendRedirect("/view/company/");
    }
}
