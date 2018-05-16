package web;

import Beans.Filial;
import database.DBUtil;
import model.user.User;
import services.MappedFilialService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Роман on 17.04.2018.
 */
@WebServlet(name = "FilialMapServlet", urlPatterns = "/map/filialMap")
public class FilialMapServlet extends HttpServlet {
    Filial filialBean = (Filial) DBUtil.lookUp("Filial");
    User user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        user = new User(Double.parseDouble(request.getParameter("x")),
                Double.parseDouble(request.getParameter("y")),
                LocalTime.parse(request.getParameter("time"), DateTimeFormatter.ofPattern("HH:mm")));
        request.setAttribute("nearest", filialBean.getRecord(MappedFilialService.findNearestFilial(filialBean.getTable(), user)));
        request.setAttribute("rs",filialBean.getTable());
        request.setAttribute("user",user);
        request.getRequestDispatcher("filialMap.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("rs", filialBean.getTable());
        request.getRequestDispatcher("filialMap.jsp").forward(request, response);
    }
}
