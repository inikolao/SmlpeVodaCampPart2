package iniko.Voda.servlets;


import iniko.Voda.DAO.Flight;
import iniko.Voda.DAO.SpecialDAO.Enums.TravelClass;
import iniko.Voda.DAO.SpecialDAO.Search;
import iniko.Voda.Services.DBServices.Crud.Repos.Impl.FlightRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.setContentType("text/html");

        System.out.println("error");
        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);
        resp.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
        resp.setHeader("Pragma", "no-cache");//http1.0
        resp.setHeader("Pragma", "0");
        FlightRepo fl=new FlightRepo();
        List<Flight> flights=fl.GetAll();
        int tftype=Integer.parseInt(req.getParameter("flight-type"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date depdate;
        Date retdate = null;
        try {
            depdate=formatter.parse(req.getParameter("depdate"));
            if(Objects.nonNull(req.getParameter("retdate")))
            {retdate=formatter.parse(req.getParameter("retdate"));}
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Search search=new Search(req.getParameter("airfrom"),req.getParameter("airto"),depdate,retdate,Integer.parseInt(req.getParameter("paseng")),Integer.parseInt(req.getParameter("chl")), TravelClass.valueOf(req.getParameter("tclass")));
        List<Flight> srOne = null;
        List<Flight> srTwo = null;
        switch (tftype){
            case 1://round trip
                srOne= Stream.of( flights.stream().filter(flight -> search.getAirportFrom().equals(flight.getHomeAirport())&&search.getAirporTo().equals(flight.getDestinationAirport())&&search.getDepDate().equals(flight.getFlightDate())&&!flight.isHasMidlleStops()).findAny().orElse(null)).collect(Collectors.toList());
                srTwo= Stream.of( flights.stream().filter(flight -> search.getAirporTo().equals(flight.getHomeAirport())&&search.getAirportFrom().equals(flight.getDestinationAirport())&&search.getRetDate().equals(flight.getFlightDate())&&!flight.isHasMidlleStops()).findAny().orElse(null)).collect(Collectors.toList());
                break;
            case 2:// One way
                srOne= Stream.of( flights.stream().filter(flight -> search.getAirportFrom().equals(flight.getHomeAirport())&&search.getAirporTo().equals(flight.getDestinationAirport())&&search.getDepDate().equals(flight.getFlightDate())&&!flight.isHasMidlleStops()).findAny().orElse(null)).collect(Collectors.toList());

                break;
            case 3://Multy city?
                srOne= Stream.of( flights.stream().filter(flight -> search.getAirportFrom().equals(flight.getHomeAirport())&&search.getAirporTo().equals(flight.getDestinationAirport())&&search.getDepDate().equals(flight.getFlightDate())&&flight.isHasMidlleStops()).findAny().orElse(null)).collect(Collectors.toList());
                break;
            default:
                System.out.println("");
        }
        req.setAttribute("Results1",srOne);
        req.setAttribute("Results2",srTwo);
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
