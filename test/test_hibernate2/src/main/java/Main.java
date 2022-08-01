import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();

            session.beginTransaction();

            session.saveOrUpdate(new Product("Banan", 11.00, "link111"));

            session.getTransaction().commit();


        } finally {
            session.close();
            factory.close();
        }
    }
}
