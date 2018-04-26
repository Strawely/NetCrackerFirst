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
@WebServlet(name = "FilialEditServlet", urlPatterns = "/view/filial/edit")
public class FilialEditServlet extends HttpServlet {
    @EJB
    private Filial filialBean = (Filial) DBUtil.lookUp("Filial");
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        int c_id = request.getParameter("company_id").equals("null") || request.getParameter("company_id").equals("") ?
                -1 : Integer.parseInt(request.getParameter("company_id"));
        filialBean.changeRecord(Integer.parseInt(request.getParameter("id")),
                c_id,
                request.getParameter("name"),
                request.getParameter("coordinates"),
                request.getParameter("startOfWork"),
                request.getParameter("endOfWork"));
        request.setAttribute("files",filialBean.getXMLList());
        request.setAttribute("rs",filialBean.getTable());
        request.getRequestDispatcher("filials.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("files",filialBean.getXMLList());
        request.setAttribute("rs", filialBean.getRecord(Integer.parseInt(request.getParameter("id"))));
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }
}
