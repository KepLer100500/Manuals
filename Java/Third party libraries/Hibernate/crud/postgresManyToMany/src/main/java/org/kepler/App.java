package org.kepler;

import org.slf4j.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.kepler.model.*;
import java.util.stream.*;
import java.util.*;
import java.text.*;


public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    private static SessionFactory createSessionFactory() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                           .addAnnotatedClass(Person.class)
                                                           .addAnnotatedClass(Interest.class)
                                                           .buildSessionFactory();
        return factory;
    }

    private static void createRecords(Session session) {
        Person person1 = Person.builder().name("Viktor")
                                         .age(20)
                                         .build();
        Person person2 = Person.builder().name("Igor")
                                         .age(25)
                                         .build();
        Interest interest1 = Interest.builder().title("Dance").build();
        Interest interest2 = Interest.builder().title("Games").build();

        person1.addInterest(interest1);
        person1.addInterest(interest2);
        interest1.addPerson(person2);
        // CascadeType not ALL!!!
        session.save(person1);
        session.save(person2);
        session.save(interest1);
        session.save(interest2);
    }

    private static void readRecords(Session session) {
        Query query1 = session.createQuery("from Person").setMaxResults(1);
        Person firstPerson = (Person)query1.uniqueResult();
        logger.info(firstPerson.toString());

        List<Person> allPersons = session.createQuery("from Person").list();
        allPersons.stream().forEach(person -> logger.info(person.toString()));

        String sqlQuery = "from Person p inner join p.interests";
        List<?> result = null;
        Query query2 = session.createQuery(sqlQuery);
        result = query2.list();

        for(Object row : result) {
            Object[] record = (Object[]) row;
            Person person = (Person)record[0];
            Interest interest = (Interest)record[1];
            logger.info(person.toString() + " " + interest.toString());
        }
        /*
        // same output result!
        for(int i=0;i<result.size();i++) {
            Object[] row = (Object[]) result.get(i);
            Person person = (Person)row[0];
            Interest interest = (Interest)row[1];
            System.out.println(person + " " + interest);
        }
        */
    }

    private static String getDateTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.SSS");
        return sdf.format(date);
    }

    private static void updateRecord(Session session) {
        Person firstPerson = (Person)session.createQuery("FROM Person p ORDER BY p.id")
                                            .setMaxResults(1)
                                            .uniqueResult();
        firstPerson.setName(getDateTime());
        logger.info(firstPerson.toString());
    }

    private static void deleteRecord(Session session) {
        Person lastPerson = (Person)session.createQuery("FROM Person p ORDER BY p.id DESC")
                                           .setMaxResults(1)
                                           .uniqueResult();
        logger.info(lastPerson.toString());
        session.delete(lastPerson);
    }

    public static void main(String[] args) {
        logger.info("Start app!");
        SessionFactory factory = createSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            createRecords(session);
            readRecords(session);
            updateRecord(session);
            deleteRecord(session);

            session.getTransaction().commit();
        } catch(HibernateException err) {
            logger.error(err.toString());
        } finally {
            session.close();
            factory.close();
        }
    }
}
