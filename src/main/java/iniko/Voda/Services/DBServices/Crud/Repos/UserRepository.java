package iniko.Voda.Services.DBServices.Crud.Repos;

import iniko.Voda.DAO.User;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public interface UserRepository extends DBRepository {

    static List<User> users = (List<User>) DBRepository.select(User.class);
     private void Fetch()
    {
        users.clear();
        List<User> userList=(List<User>) DBRepository.select(User.class);
        users.addAll(userList);

    }
    default User FindUserByUsernane(String value)
    {
        Fetch();
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
       // DBRepository.select(User.class);
        return users;
    }

}
