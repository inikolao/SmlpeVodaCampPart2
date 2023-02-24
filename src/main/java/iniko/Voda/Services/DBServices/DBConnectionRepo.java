package iniko.Voda.Services.DBServices;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DBConnectionRepo {

    private static SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public DBConnectionRepo()
    {}
}
