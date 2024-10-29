package ConnectionToDB;

import entity.User;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

@Getter
public class ConnectionToDB implements Serializable {
    protected static SessionFactory sessionFactory;
    protected static Session session;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (User.class) {
                if (sessionFactory == null) {
                    try {
                        sessionFactory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .buildSessionFactory();
                    } catch (Throwable ex) {
                        throw new ExceptionInInitializerError("SessionFactory creation failed: " + ex);
                    }
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdownDBConnection() {
        // Close caches and connection pools
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public static void startSession() {
        if (session == null) {
            session = sessionFactory.openSession();
        }
    }

    public static void closeSession() {
        if (session != null) {
            session.close();
        }
    }

}
