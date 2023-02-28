package iniko.Voda.servlets;

import iniko.Voda.DAO.User;
import iniko.Voda.Services.DBServices.Crud.Repos.Impl.UserRepo;
import iniko.Voda.Services.DBServices.Crud.Repos.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);
        resp.setContentType("text/html");

        System.out.println("error");
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
        resp.setHeader("Pragma", "no-cache");//http1.0
        resp.setHeader("Pragma", "0");//proxies
        UserRepository urepo=new UserRepo();
        User uf=urepo.FindUserByUsernane(req.getParameter("email"));
        if(Objects.nonNull(uf))
        {
            System.out.println("db Fu: "+uf.getUsername());
            if (uf.getPassword().equals(req.getParameter("password")))
            {
                System.out.println("ok");
                resp.setContentType("text/html");
                HttpSession session = req.getSession();
                if (uf.getUsername().contains("admin")) {
                    session.setAttribute("admin","yes");
                    resp.sendRedirect("admin/dashboard.jsp");
                } else {
                    session.setAttribute("user","yes");
                    session.setAttribute("username",uf.getUsername());
                    resp.sendRedirect("user/home.jsp");
                }
            }
            else
            {
                resp.setContentType("text/html");

                System.out.println("error");
                resp.sendRedirect("login.jsp");
            }
        }
        else
        {
            resp.setContentType("text/html");

            System.out.println("error");
            resp.sendRedirect("login.jsp");
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
