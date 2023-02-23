package iniko.Voda.Services.DBServices;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class DBConnection implements IDBConnect{

    private static SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    public DBConnection() {

        sessionFactory=buildSessionFactory();
    }

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public Session InialiseDBSession(SessionFactory sessionFactory) {
        session=sessionFactory.openSession();
        return session;
    }

    @Override
    public Transaction StartTransaction(Session session) {
        transaction= session.beginTransaction();
        return transaction;
    }

    @Override
    public void CommitTransaction(Transaction transaction) {
        transaction.commit();
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        DBConnection.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    private static SessionFactory buildSessionFactory() {
        System.out.println("build factory");
        try {
            // Create the ServiceRegistry from hibernate.cfg.xml
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

            // Create a metadata sources using the specified service registry.
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
