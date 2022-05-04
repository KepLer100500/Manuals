package learn_annotation_context_without_xml;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        
        Pet pet = context.getBean("myPet1", Pet.class);
        pet.say();

        PersonWithSetters personWithSetters = context.getBean("personBeanSetter", PersonWithSetters.class);
        personWithSetters.callPet();

        PersonWithField personWithField = context.getBean("personBeanField", PersonWithField.class);
        personWithField.callPet();

        PersonWithConstructor personWithConstructor = context.getBean("personBeanConstructor", PersonWithConstructor.class);
        personWithConstructor.callPet();

        context.close();

    }
}
