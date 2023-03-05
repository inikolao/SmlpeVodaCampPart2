package iniko.Voda.servlets;

import iniko.Voda.DAO.Airliner;
import iniko.Voda.DAO.Flight;
import iniko.Voda.Services.DBServices.Crud.Repos.Impl.AirlinerRepo;
import iniko.Voda.Services.DBServices.Crud.Repos.Impl.FlightRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/booka")
public class AirlinerFlights extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        AirlinerRepo repo=new AirlinerRepo();
        int id= Integer.parseInt(req.getParameter("valueair"));
        System.out.println("id "+id);
        Airliner airliner=repo.GetAirlinerById(id);
        FlightRepo flightRepo=new FlightRepo();
        List<Flight> flights=flightRepo.GetAll();
        List<Flight> flightsRES=flights.stream().filter(q->q.getAirliner().getName().equals(airliner.getName())).collect(Collectors.toList());
        req.setAttribute("Results1",flightsRES);
        req.getRequestDispatcher("results.jsp").forward(req, resp);
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
