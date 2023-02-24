package iniko.Voda.Listeners;

import iniko.Voda.DAO.User;
import iniko.Voda.Services.DBServices.DBConnection;
import org.hibernate.Session;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.time.Instant;
import java.util.Date;


@WebListener
public class ContexListener implements ServletContextListener, ServletContextAttributeListener {

    public ContexListener() {
        System.out.println("Contex Control Started");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        ServletContextAttributeListener.super.attributeAdded(event);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        ServletContextAttributeListener.super.attributeRemoved(event);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        ServletContextAttributeListener.super.attributeReplaced(event);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        User Admin= new User();
        Admin.setAdmin(true);
        Admin.setUsername("admin@cn");
        Admin.setPassword("papaki");
        Date dateOne = new Date();
        Instant inst = Instant.now();
        Admin.setResistrationActive(dateOne.from(inst));
        Admin.setActive(true);
        DBConnection dbConnection=new DBConnection();
       Session sn= dbConnection.InialiseDBSession(dbConnection.getSessionFactory());
       dbConnection.StartTransaction(sn);
       sn.saveOrUpdate(Admin);
       dbConnection.CommitTransaction(dbConnection.getTransaction());
       //sn.close();
        //dbConnection.setSession(sn);
        ServletContext sc=sce.getServletContext();
        sc.setAttribute("sessionDB",dbConnection);
        ServletContextListener.super.contextInitialized(sce);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
