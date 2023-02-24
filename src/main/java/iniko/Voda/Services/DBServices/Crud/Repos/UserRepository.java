package iniko.Voda.Services.DBServices.Crud.Repos;

import iniko.Voda.DAO.User;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public interface UserRepository extends DBRepository {

    static List<User> users = (List<User>) DBRepository.select(User.class);
    default void initialise(SessionFactory sessionFactory)
    {
        DB_CONNECTION.setSessionFactory(sessionFactory);
        DB_CONNECTION.InialiseDBSession(sessionFactory);
    }
    default User FindUserByUsernane(String value)
    {
        for (User x:users)
             {
                 //System.out.println(x.getUsername());
                 if(x.getUsername().equals(value))
                 {
                     return x;
                 }
             }

        return null;
    }
    default List<User> GetAll()
    {
        return users;
    }

}
