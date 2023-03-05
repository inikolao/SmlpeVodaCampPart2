package iniko.Voda.Services.DBServices.Crud.Repos;

import iniko.Voda.DAO.Ticket;

import java.util.List;

public interface TicketsRepository extends DBRepository{
    static List<Ticket> tickets = (List<Ticket>) DBRepository.select(Ticket.class);
    private void Fetch()
    {
        tickets.clear();
        List<Ticket> userList=(List<Ticket>) DBRepository.select(Ticket.class);
        tickets.addAll(userList);

    }

    default Ticket FindUserByID(int value)
    {
        Fetch();
        for (Ticket x:tickets)
        {
            //System.out.println(x.getUsername());
            if(x.getId()==value)
            {
                return x;
            }
        }

        return null;
    }
    default Ticket FindUserByOwner(int OwnerValue)
    {
        Fetch();
        for (Ticket x:tickets)
        {
            //System.out.println(x.getUsername());
            if(x.getPassenger().getId()==OwnerValue)
            {
                return x;
            }
        }

        return null;
    }
    default List<Ticket> GetAll()
    {
        // DBRepository.select(User.class);
        return tickets;
    }
}
