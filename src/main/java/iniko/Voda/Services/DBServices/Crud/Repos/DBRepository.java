package iniko.Voda.Services.DBServices.Crud.Repos;

import iniko.Voda.Services.DBServices.DBConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public interface DBRepository {

    DBConnection DB_CONNECTION=new DBConnection(2);
    Session SESSION= DB_CONNECTION.InialiseDBSession(DB_CONNECTION.getSessionFactory());
    Transaction TRANSACTION=DB_CONNECTION.getTransaction();
    default void save(Object obj)
    {
        SESSION.beginTransaction();
        SESSION.save(obj);
        TRANSACTION.commit();
        SESSION.close();

    }
    default void saveX(Object obj)
    {
        DBConnection con=new DBConnection(2);
        Session sn=con.InialiseDBSession(con.getSessionFactory());
        Transaction tx=con.StartTransaction(sn);
        sn.save(obj);
        tx.commit();
        sn.close();

    }
    default void delete(Object obj)
    {
        SESSION.beginTransaction();
        SESSION.delete(obj);
        TRANSACTION.commit();
        SESSION.close();
    }
    static Object select(Class clasof )
    {
        Transaction tx=SESSION.beginTransaction();
        CriteriaQuery<Object> cq = SESSION.getCriteriaBuilder().createQuery(clasof);
        cq.from(clasof);
        List<Object> objectList = SESSION.createQuery(cq).getResultList();
        return objectList;

    }
}
