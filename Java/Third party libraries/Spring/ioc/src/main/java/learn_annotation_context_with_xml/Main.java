package learn_annotation_context_with_xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAnnotation.xml");
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
