package com.turkovaleksey.test.test_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.saveOrUpdate(new Product("name", 0.00, "link"));
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
