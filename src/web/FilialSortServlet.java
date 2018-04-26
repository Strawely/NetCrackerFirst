package web;

import Beans.Company;
import Beans.Filial;
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
@WebServlet(name = "FilialSortServlet", urlPatterns = "/view/filial/sort")
public class FilialSortServlet extends HttpServlet {
    @EJB
    private Filial filialBean = (Filial) DBUtil.lookUp("Filial");
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("files",filialBean.getXMLList());
        request.setAttribute("rs", filialBean.getSortedTable(Integer.parseInt(request.getParameter("n"))));
        request.getRequestDispatcher("filials.jsp").forward(request, response);
    }
}
