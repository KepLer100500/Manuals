import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(TestTable.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            TestTable post = new TestTable("some text");
            session.beginTransaction();
            session.save(post);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
