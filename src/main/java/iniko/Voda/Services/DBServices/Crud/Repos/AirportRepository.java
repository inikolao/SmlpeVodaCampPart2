package iniko.Voda.Services.DBServices.Crud.Repos;

import iniko.Voda.DAO.Airport;

import java.util.List;

public interface AirportRepository extends DBRepository {
    static List<Airport> airports = (List<Airport>) DBRepository.select(Airport.class);
    private void Fetch()
    {
        airports.clear();
        List<Airport> FlightList=(List<Airport>) DBRepository.select(Airport.class);
        airports.addAll(FlightList);

    }
    default Airport GetFlightById(int ID)
    {
        Fetch();
        for (Airport a:airports) {
            if (a.getId()==ID)
            {
                return a;
            }
        }
        return null;
    }
    default List<Airport> GetAll()
    {
        return airports;
    }
}
