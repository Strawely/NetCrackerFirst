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
 * Created by Роман on 23.02.2018.
 */
@WebServlet(name = "FilialServlet", urlPatterns = "/view/filial/")
public class FilialServlet extends HttpServlet {
    @EJB
    private Filial filialBean = (Filial) DBUtil.lookUp("Filial");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        if (request.getParameterMap().containsKey("load"))
            request.getRequestDispatcher("/view/filial/xml").forward(request, response);
        else if (request.getParameter("saveID") != null) {
            response.sendRedirect("/view/filial/xml");
        } else {
            request.setAttribute("files",filialBean.getXMLList());
            request.setAttribute("rs", filialBean.getSearchResult(Integer.parseInt(request.getParameter("col")), request.getParameter("expr")));
            request.getRequestDispatcher("filials.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("files",filialBean.getXMLList());
        request.setAttribute("rs", filialBean.getTable());
        request.getRequestDispatcher("filials.jsp").forward(request, response);
    }
}
