package iniko.Voda.servlets;


import iniko.Voda.DAO.Flight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book")
public class BookFlightServlet extends HttpServlet {
    public BookFlightServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.out.println(req.getParameter("value").toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        System.out.println(req.getParameter("value").toString());
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
