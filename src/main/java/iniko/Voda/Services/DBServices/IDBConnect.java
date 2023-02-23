package iniko.Voda.Services.DBServices;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public interface IDBConnect {

    SessionFactory getSessionFactory();
    Session InialiseDBSession(SessionFactory sessionFactory);
    Transaction StartTransaction(Session session);
    void CommitTransaction(Transaction transaction);

}
