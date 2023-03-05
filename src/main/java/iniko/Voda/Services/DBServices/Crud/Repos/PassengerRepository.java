package iniko.Voda.Services.DBServices.Crud.Repos;

import iniko.Voda.DAO.Passenger;

import java.util.List;

public interface PassengerRepository extends DBRepository{
    static List<Passenger> passengers = (List<Passenger>) DBRepository.select(Passenger.class);
    private void Fetch()
    {
        passengers.clear();
        List<Passenger> userList=(List<Passenger>) DBRepository.select(Passenger.class);
        passengers.addAll(userList);

    }

    default Passenger FindPassengerByID(int value)
    {
        Fetch();
        for (Passenger x:passengers)
        {
            //System.out.println(x.getUsername());
            if(x.getId()==value)
            {
                return x;
            }
        }

        return null;
    }
    default Passenger FindUserByID(int UserValue)
    {
        Fetch();
        for (Passenger x:passengers)
        {
            //System.out.println(x.getUsername());
            if(x.getUser().getId()==UserValue)
            {
                return x;
            }
        }

        return null;
    }
    default List<Passenger> GetAll()
    {
        // DBRepository.select(User.class);
        return passengers;
    }
}
