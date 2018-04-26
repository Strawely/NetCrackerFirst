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
 * Created by Роман on 23.02.2018.
 */
@WebServlet(name = "CompanyDelServlet", urlPatterns = "/view/company/delete")
public class CompanyDelServlet extends HttpServlet {
    @EJB
    private Company companyBean = (Company) DBUtil.lookUp("Company");
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        companyBean.removeByID(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("files",companyBean.getXMLList());
        request.setAttribute("rs",companyBean.getTable());
        request.getRequestDispatcher("companies.jsp").forward(request,response);
    }
}
