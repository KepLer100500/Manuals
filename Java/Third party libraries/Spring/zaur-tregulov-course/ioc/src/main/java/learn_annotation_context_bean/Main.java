package learn_annotation_context_bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        
        Pet pet = context.getBean("myPet1", Pet.class);
        pet.say();

        Person person = context.getBean("person", Person.class);
        person.callPet();

        context.close();
    }
}
