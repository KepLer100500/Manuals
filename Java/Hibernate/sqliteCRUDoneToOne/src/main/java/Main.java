import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Optional;


public class Main  {
    private static Object getRecord(Session session, String entity, int id) {
        return session.get(entity, id);
    }

    private static List<?> getRecords(Session session, String query) {
        return session.createQuery(query).getResultList();
    }

    private static void addPerson(Session session, String name, int age, String email) {
        Person person = new Person(name, age);
        PersonDetails details = new PersonDetails(email);
        person.setDetails(details);
        session.save(person);
    }

    private static void editPerson(Session session, int id) {
        Person person = (Person)getRecord(session, "Person", id);
        person.setName(new java.util.Date().toString());
    }

    private static void editPersons(Session session) {
        String query = "update Person set name='fff' " +
                "where id > (select min(id) from Person) and id < (select max(id) from Person)";
        session.createQuery(query).executeUpdate();
    }

    private static void removeRecord(Session session, String entity, int id) {
        // delete records into two tables - link work
        try {
            session.delete(getRecord(session, entity, id));
        } catch (IllegalArgumentException err) {
            System.out.println(err.toString());
        }
    }

    private static void removePreviousPerson(Session session) {
        String entity = "Person";
        List<?> records = getRecords(session, "from " + entity);
        Optional<Integer> maxIdOpt = records.stream()
                                    .map(n -> ((Person)n))
                                    .map(Person::getId)
                                    .max(Integer::compare);
        int maxId = 0;
        if (maxIdOpt.isPresent()) {
            maxId = maxIdOpt.get();
        }
        maxId--; // previous record
        try {
            removeRecord(session, entity, maxId);
        } catch (IllegalArgumentException err) {
            System.out.println(err.toString());
        }
    }

    private static void removeEvenRecords(Session session) {
        // delete records only into Person table! link not work!
        String query = "delete from Person where id % 2 = 0";
        session.createQuery(query).executeUpdate();
    }

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(PersonDetails.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            addPerson(session, "Igor", 20, "igor@igor.ru");
            System.out.println("!!!!!" + getRecord(session, "Person", 11));
            System.out.println("!!!!!" + getRecord(session, "PersonDetails", 11));
            System.out.println("!!!!!" + getRecords(session, "from Person"));

            editPerson(session, 11);
            System.out.println("!!!!!" + getRecord(session, "Person", 11));

            removePreviousPerson(session);
            System.out.println("!!!!!" + getRecords(session, "from Person"));

            editPersons(session);
            System.out.println("!!!!!" + getRecords(session, "from Person"));

            removeEvenRecords(session);
            System.out.println("!!!!!" + getRecords(session, "from Person"));

            session.getTransaction().commit();
        }
        finally {
            assert session != null;
            session.close();
            factory.close();
        }
    }
}
