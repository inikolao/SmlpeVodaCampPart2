package iniko.Voda.Services.DBServices.Crud.Repos;

import iniko.Voda.DAO.Flight;

import java.util.List;
import java.util.stream.Collectors;

public interface PlacesRepository extends DBRepository{
    List<String> Places=((List<Flight>) DBRepository.select(Flight.class)).stream().map(Flight::getDestinationAirport).collect(Collectors.toList());
    private void Fetch()
    {

        Places.clear();
        List<String> PlacesList=((List<Flight>) DBRepository.select(Flight.class)).stream().map(Flight::getDestinationAirport).collect(Collectors.toList());
        Places.addAll(PlacesList);

    }
    default List<String> GetAll()
    {
        return Places;
    }
}
