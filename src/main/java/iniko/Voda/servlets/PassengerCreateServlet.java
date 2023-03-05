package iniko.Voda.servlets;

import iniko.Voda.DAO.Passenger;
import iniko.Voda.DAO.User;
import iniko.Voda.Services.DBServices.Crud.Repos.Impl.PassengerRepo;
import iniko.Voda.Services.DBServices.Crud.Repos.Impl.UserRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/create")
public class PassengerCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        String pname= req.getParameter("pname").toString();
        String psurname= req.getParameter("psurname").toString();
        HttpSession sn = req.getSession();
        int uid= (int) sn.getAttribute("user_id");
        UserRepo repo=new UserRepo();
        User user=repo.FindUserByID((Integer) sn.getAttribute("user_id"));
        PassengerRepo passengerRepo=new PassengerRepo();
        Passenger passenger=new Passenger();
        passenger.setUser(user);
        passenger.setSurname(psurname);
        passenger.setName(pname);
        passengerRepo.save(passenger);
        user.setPassenger(true);
        repo.update(user);
        sn.setAttribute("psc",true);
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
