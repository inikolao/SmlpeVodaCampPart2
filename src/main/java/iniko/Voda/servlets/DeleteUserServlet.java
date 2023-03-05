package iniko.Voda.servlets;

import iniko.Voda.DAO.User;
import iniko.Voda.Services.DBServices.Crud.Repos.Impl.UserRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userDelete")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        UserRepo repo=new UserRepo();
        int id= Integer.parseInt(req.getParameter("did").toString());
        User user=repo.FindUserByID(id);
        repo.delete(user);
        resp.sendRedirect("admin/users.jsp");
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
