package iniko.Voda.Services.DBServices.Crud.Repos;

import iniko.Voda.Services.DBServices.DBConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public interface DBRepository {

    DBConnection DB_CONNECTION =new DBConnection(1);
    //SessionFactory SESSION_FACTORY= DB_CONNECTION.getSessionFactory();

    static Session initialise()
    {
        SessionFactory sessionFactory= DB_CONNECTION.getSessionFactory();
        return DB_CONNECTION.InialiseDBSession(sessionFactory);

    }

    default void save(Object obj)
    {
        Session sn=initialise();
        sn.beginTransaction();
        sn.save(obj);
        sn.getTransaction().commit();
        sn.close();


    }

    default void update(Object obj)
    {
        Session sn=initialise();
        sn.beginTransaction();
        sn.update(obj);
        sn.getTransaction().commit();
        sn.close();


    }
    default void delete(Object obj)
    {
        Session sn=initialise();
        sn.beginTransaction();
        sn.delete(obj);
        sn.getTransaction().commit();
        sn.close();
    }

    default void find(Class clasof, int id)
    {
        Session sn=initialise();
        sn.beginTransaction();
        sn.find(clasof,id);
        sn.getTransaction().commit();
        sn.close();
    }
    static Object select(Class clasof )
    {
        Session sn=initialise();
        CriteriaQuery<Object> cq = sn.getCriteriaBuilder().createQuery(clasof);
        cq.from(clasof);
        List<Object> objectList = sn.createQuery(cq).getResultList();
        sn.close();
        return objectList;
    }
}
