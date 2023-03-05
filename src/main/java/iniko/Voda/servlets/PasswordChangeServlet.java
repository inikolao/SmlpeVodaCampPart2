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

@WebServlet("/pchange")
public class PasswordChangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
       String newPass= req.getParameter("password").toString();
        HttpSession sn = req.getSession();
        UserRepo repo=new UserRepo();
        User user=repo.FindUserByID((Integer) sn.getAttribute("user_id"));
        user.setPassword(newPass);
        repo.update(user);
        sn.setAttribute("psc",true);
        if(user.isAdmin())
        resp.sendRedirect("admin/settings.jsp");
        else
            resp.sendRedirect("user/settings.jsp");
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
