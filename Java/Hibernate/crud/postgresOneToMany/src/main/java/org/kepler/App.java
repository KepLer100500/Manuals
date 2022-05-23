package org.kepler;

import org.slf4j.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.kepler.model.*;
import java.util.stream.*;
import java.util.*;


public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    private static SessionFactory createSessionFactory() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Post.class)
                                                    .addAnnotatedClass(Category.class)
                                                    .addAnnotatedClass(Comment.class)
                                                    .buildSessionFactory();
        return factory;
    }

    private static int getLastRecordId(Session session, Class<? extends Blog> clz) {
        String tableName = clz.getName(); // get class name
        Query query = session.createQuery(String.format("from %s order by id DESC", tableName))
                             .setMaxResults(1);
        Object lastRecord = query.uniqueResult();
        return clz.cast(lastRecord).getId();
    }

    private static Object getRecord(Session session, Class clz, int id) {       
        return session.get(clz, id);
    }

    private static void createRecord(Session session) {
        // create instances and insert records
        Category category = Category.builder()
                                    .name("category + post + comment")
                                    .build();

        Post post = Post.builder()
                    .title("post title + comment")
                    .fullText("post text + comment")
                    .category(category)
                    .build();

        Comment comment1 = Comment.builder()
                    .author("author 1")
                    .message("message 1")
                    .post(post)
                    .build();
        Comment comment2 = Comment.builder()
                    .author("author 2")
                    .message("message 2")
                    .post(post)
                    .build();
        Comment comment3 = Comment.builder()
                    .author("author 3")
                    .message("message 3")
                    .post(post)
                    .build();

        category.addPost(post);
        post.addMessage(comment1);
        post.addMessage(comment2);
        post.addMessage(comment3);

        session.save(category);
    }

    private static void readLastCategoryRecord(Session session) {
        // select category and posts
        Class clz = Category.class;
        int lastRecordId = getLastRecordId(session, clz);
        Object categoryRecord = getRecord(session, clz, lastRecordId);
        logger.info(categoryRecord.toString());
        ((Category)categoryRecord).getPosts().stream().forEach(post -> logger.info(post.toString()));
    }

    private static void updateLastPost(Session session) {
        // update last post text
        Class clz = Post.class;
        int lastRecordId = getLastRecordId(session, clz);
        Object record = getRecord(session, clz, lastRecordId);
        ((Post)record).setFullText("new updated text");
        logger.info(record.toString());
    }

    private static void deleteLastComment(Session session) {
        // delete comment
        Class clz = Comment.class;
        int lastRecordId = getLastRecordId(session, clz);
        Comment comment = (Comment)getRecord(session, clz, lastRecordId);
        Post post = comment.getPost(); // get linked post record
        post.removeComment(comment); // remove comment from post list
        session.delete(comment); // remove comment from table
    }

    private static void doCrudOperations(Session session) {
        createRecord(session);
        readLastCategoryRecord(session);
        updateLastPost(session);
        deleteLastComment(session);
    }

    public static void main(String[] args) {
        logger.info("Program run!");
        SessionFactory factory = createSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            
            doCrudOperations(session);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
