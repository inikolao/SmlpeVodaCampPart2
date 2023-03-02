package iniko.Voda.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
        resp.setHeader("Pragma", "no-cache");//http1.0
        resp.setHeader("Pragma", "0");//proxies
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        String admin = (String) session.getAttribute("admin");
        String user=(String) session.getAttribute("user");
        System.out.println("Logout Rq URI:  "+((HttpServletRequest) req).getRequestURI().toString() );
        if(admin != null) {
            session.invalidate();
            System.out.println("Admin logout");
        }
        if(user != null) {
            session.invalidate();
            System.out.println("User logout");
        }


        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
