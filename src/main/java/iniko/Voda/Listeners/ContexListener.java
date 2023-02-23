package iniko.Voda.Listeners;

import iniko.Voda.DAO.User;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.time.Instant;
import java.util.Date;

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
        Admin.setUsername("Admin");
        Admin.setPassword("papaki");
        Date dateOne = new Date();
        Instant inst = Instant.now();
        Admin.setResistrationActive(dateOne.from(inst));
        Admin.setActive(true);

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
