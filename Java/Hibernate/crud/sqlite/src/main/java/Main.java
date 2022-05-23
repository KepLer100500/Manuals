import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Main {
    private static TestTable getRecord(Session session, int id) {
        return session.get(TestTable.class, id);
    }

    private static List<TestTable> getRecords(Session session, String query) {
        return session.createQuery(query).getResultList();
    }

    private static void insertRecord(Session session, String title) {
        TestTable post = new TestTable(title);
        session.save(post);
    }

    private static void updateRecord(Session session, int id) {
        TestTable post = getRecord(session, id);
        post.setTitle(new java.util.Date().toString());
    }

    private static void deleteRecord(Session session, int id) {
        try {
            session.delete(getRecord(session, id));
        } catch (IllegalArgumentException err) {
            System.out.println(err.toString());
        }
    }

    private static void deleteOrUpdateRecords(Session session, String query) {
        session.createQuery(query).executeUpdate();
    }

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(TestTable.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            // select
            System.out.println(getRecord(session, 1));
            System.out.println(getRecords(session, "from TestTable where id > 3 and title like '%text%'"));
            // delete
            deleteRecord(session, 3);
            deleteOrUpdateRecords(session, "delete from TestTable where id > 5");
            // update
            updateRecord(session, 1);
            deleteOrUpdateRecords(session, "update TestTable set title='another title' where id = 2");
            // insert
            insertRecord(session, "some text");

            System.out.println(getRecords(session, "from TestTable"));
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
