package iniko.Voda.servlets;

import iniko.Voda.DAO.User;
import iniko.Voda.Services.DBServices.Crud.Repos.Impl.UserRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.setContentType("text/html");

        System.out.println("error");
        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        User reus=new User();
        reus.setUsername(req.getParameter("username"));
        reus.setPassword(req.getParameter("password"));
        reus.setAddress(req.getParameter("address"));
        reus.setPhone(Integer.parseInt(req.getParameter("phone")));
        reus.setResistrationActive();
        reus.setAdmin(false);
        reus.setActive(true);
        UserRepo repo=new UserRepo();
       // repo.save(reus);
        repo.saveX(reus);
        req.getParameter("isAdult");//deprecated
        HttpSession session = req.getSession();
        session.setAttribute("user","yes");
        session.setAttribute("username",reus.getUsername());
        resp.sendRedirect("user/home.jsp");
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
