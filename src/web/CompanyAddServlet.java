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
 * Created by Роман on 03.03.2018.
 */
@WebServlet(name = "CompanyAddServlet",urlPatterns = "/view/company/add")
public class CompanyAddServlet extends HttpServlet {
    @EJB
    private Company companyBean = (Company) DBUtil.lookUp("Company");
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        int d_id = request.getParameter("director_id").equals("") || request.getParameter("director_id").equals("null") ?
                -1 : Integer.parseInt(request.getParameter("director_id"));
        companyBean.addRecord(d_id,
                request.getParameter("name"),
                request.getParameter("focusarea"));
        request.setAttribute("files",companyBean.getXMLList());
        request.setAttribute("rs", companyBean.getTable());
        request.getRequestDispatcher("companies.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("add.jsp").forward(request, response);

    }
}
