package iniko.Voda.servlets;

import iniko.Voda.DAO.User;
import iniko.Voda.Listeners.ContexListener;
import iniko.Voda.Services.DBServices.DBConnection;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConnection db=(DBConnection) getServletContext().getAttribute("sessionDB");
        System.out.println("Look !  "+req.getAttributeNames().toString());
        System.out.println("Look !  "+db.toString());
        //db.getSession().
        //CriteriaQuery<User> cq= db.getSession().getCriteriaBuilder().createQuery(User.class);
        //CriteriaQuery<Book> cq = session.getCriteriaBuilder().createQuery(Book.class);
         CriteriaQuery<User> criteriaQuery=  db.getSession().getCriteriaBuilder().createQuery(User.class);
         Root<User> root = criteriaQuery.from(User.class);
         criteriaQuery.select(root).;

         criteriaQuery.select(criteriaQuery.from(User.class));
        criteriaQuery.where(builder.equal(pageField.get("page").get("id"), pageId));

         SearchResult<Book> result = Search.session( entityManager )
                .search( Book.class )
                .where( f -> f.match()
                        .fields( "title", "authors.name" )
                        .matching( "Isaac" ) )
                .fetch( 20 );
        Criteria cr = session.createCriteria(Employee.class);
        cr.add(Restrictions.eq("salary", 2000));
        List results = cr.list();
        // cq.from(User.class);
        resp.setContentType("text/html");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        resp.sendRedirect("Dashboard");

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
