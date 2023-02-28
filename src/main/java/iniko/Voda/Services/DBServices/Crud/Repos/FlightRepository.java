package iniko.Voda.Services.DBServices.Crud.Repos;

import iniko.Voda.DAO.Flight;
import org.hibernate.SessionFactory;

import java.util.List;

public interface FlightRepository extends DBRepository {
    static List<Flight> flights = (List<Flight>) DBRepository.select(Flight.class);

    default void initialise(SessionFactory sessionFactory)
    {
        DB_CONNECTION.setSessionFactory(sessionFactory);
        DB_CONNECTION.InialiseDBSession(sessionFactory);
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
