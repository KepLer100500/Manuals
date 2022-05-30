package org.kepler;

import org.slf4j.*;
import org.springframework.context.annotation.*;


public class App {
    public static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {
        logger.info("Run program");
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(MyConfig.class);
        
        Book book = context.getBean("book", Book.class);

        Library library = null;
        library = context.getBean("uniLibrary", Library.class);
        library.getBook();
        library.getMagazine();
        library.returnBook();
        library.buyBook(book, 500);
        library.buyMagazine("Magazine1 from uniLibrary");

        library = context.getBean("schoolLibrary", Library.class);
        library.getBook();
        library.getMagazine();
        library.returnBook();
        library.buyBook(book, 300);
        library.buyMagazine("Magazine2 from schoolLibrary");
        // AfterReturning
        Student student1 = context.getBean("student", Student.class);
        Student student2 = context.getBean("student", Student.class);
        student1 = Student.builder()
                          .nameSurname("KepLer")
                          .course(5)
                          .avgRate(9.5)
                          .build();
        student2 = Student.builder()
                          .nameSurname("Flame")
                          .course(3)
                          .avgRate(7.3)
                          .build();
        University university = context.getBean("university", University.class);
        university.addStudent(student1);
        university.addStudent(student2);

        logger.info("------------------------------------");
        logger.warn(university.toString());
        university.getStudents(); // change data <- working afterReturning advice!!!
        logger.warn(university.toString());
        logger.info("------------------------------------");

        try {
            university.badListStudents();
        } catch(Exception e) {
            logger.error("Catching exception in Main class! " + e.toString());
        }

        String puttedBook = library.putBook();
        logger.info(puttedBook); // in SchoolLibrary -> return "Put SchoolLibrary book";
        
        context.close();
    }
}
