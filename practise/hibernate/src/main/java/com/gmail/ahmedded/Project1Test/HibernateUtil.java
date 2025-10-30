package com.gmail.ahmedded.Project1Test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 📘 Утилита для создания SessionFactory
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            System.out.println("🔄 Подключение к базе данных...");
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("❌ Ошибка при создании SessionFactory: " + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
