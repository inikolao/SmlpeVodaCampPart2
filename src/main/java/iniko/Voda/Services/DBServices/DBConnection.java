package iniko.Voda.Services.DBServices;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DBConnection implements IDBConnect{

    //private static final SessionFactory sessionFactory = null;
    public DBConnection() {
    }

    @Override
    public SessionFactory getSessionFactory() {
        return null;
    }

    @Override
    public Session InialiseDBSession(SessionFactory sessionFactory) {
        return null;
    }

    @Override
    public Transaction StartTransaction(Session session) {
        return null;
    }

    @Override
    public void CommitTransaction(Transaction transaction) {

    }
}
