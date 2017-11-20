package goit.gojava7.ryzhkov.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StorageUtils {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }

}
