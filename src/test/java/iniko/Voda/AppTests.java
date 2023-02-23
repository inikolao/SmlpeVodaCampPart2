package iniko.Voda;

import iniko.Voda.Configuration.HibernateConfig;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.hibernate.SessionFactory;

/**
 * Unit test for simple App.
 */
public class AppTests
        extends TestCase
{
    private static SessionFactory factory;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTests( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTests.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public void testSessionFactory()
    {
        //assertTrue( true );
        factory= HibernateConfig.getSessionFactory();
        assertNotNull(factory);

    }

    /*public void testBoot()
    {
        flight f=new flight();
        //b.setBid(1);
        f.
        f.setPrice(23);
        f.setTitle("something");
        factory=HibernteConfig.getSessionFactory();
        Session session= factory.openSession();
        Transaction tx=session.beginTransaction();
        Integer id= (Integer) session.save(b);
        tx.commit();
        session.close();
        assertNotNull(id);
    }*/
}
