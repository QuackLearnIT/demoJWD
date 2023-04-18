package fa.training.demojwd.model.util;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.PrintWriter;

public class HibernateConnectionConfig {
    private static final SessionFactory sessionFactory;

    private HibernateConnectionConfig() {}

    static {
        Configuration configuration = new Configuration();
        configuration.configure(); // load properties from hibernate.cfg.xml
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}