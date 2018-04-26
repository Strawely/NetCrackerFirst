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
 * Created by Роман on 12.04.2018.
 */
@WebServlet(name = "FilialXMLServlet",urlPatterns = "/view/filial/xml")
public class FilialXMLServlet extends HttpServlet {
    @EJB
    Filial filial = (Filial) DBUtil.lookUp("Filial");
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        filial.importFromXML(Integer.parseInt(request.getParameter("file").split("\\.")[0]));
        response.sendRedirect("/view/filial/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        filial.convertToXML(Integer.parseInt(request.getParameter("saveID")));
        response.sendRedirect("/view/filial/");
    }
}
