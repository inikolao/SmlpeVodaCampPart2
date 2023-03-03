package iniko.Voda.Services.DBServices.Crud.Repos;

import iniko.Voda.DAO.Airliner;

import java.util.List;

public interface AirlineRepository  extends DBRepository{
    static List<Airliner> airliners = (List<Airliner>) DBRepository.select(Airliner.class);
    private void Fetch()
    {
        airliners.clear();
        List<Airliner> FlightList=(List<Airliner>) DBRepository.select(Airliner.class);
        airliners.addAll(FlightList);

    }
    default Airliner GetFlightById(int ID)
    {
        Fetch();
        for (Airliner airliner:airliners) {
            if (airliner.getId()==ID)
            {
                return airliner;
            }
        }
        return null;
    }
    default List<Airliner> GetAll()
    {
        return airliners;
    }
}
