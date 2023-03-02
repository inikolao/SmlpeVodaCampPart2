package iniko.Voda.Services.DBServices.Crud.Repos;

import iniko.Voda.DAO.Flight;
import iniko.Voda.DAO.User;
import org.hibernate.SessionFactory;

import java.util.List;

public interface FlightRepository extends DBRepository {
    static List<Flight> flights = (List<Flight>) DBRepository.select(Flight.class);
    private void Fetch()
    {
        flights.clear();
        List<Flight> FlightList=(List<Flight>) DBRepository.select(Flight.class);
        flights.addAll(FlightList);

    }
    default Flight GetFlightById(int ID)
    {
        for (Flight f:flights) {
            if (f.getId()==ID)
            {
                return f;
            }
        }
        return null;
    }
    default List<Flight> GetAll()
    {
        return flights;
    }
}
