package com.ems.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory factory;

    static {
        try {
            // Load configuration and build SessionFactory
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}