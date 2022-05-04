package learn_xml_context;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // cat and dog beans - singleton, that's why init both beans!
        demoBasic(context);
        demoDI(context);
        demoScope(context);

        context.close();
    }

    private static void demoBasic(ClassPathXmlApplicationContext context) {
        System.out.println("\n=== Basic ===");
        Pet pet = context.getBean("myPet1", Pet.class);
        pet.say();
    }

    private static void demoDI(ClassPathXmlApplicationContext context) {
        System.out.println("\n=== DI ===");

        Person person = null;
        person = context.getBean("myPersonByConstructor", Person.class);
        person.callPet();

        person = context.getBean("myPersonBySetter", Person.class);
        person.callPet();

        person = context.getBean("myPersonBySetterFromFile", Person.class);
        person.callPet();
    }

    private static void demoScope(ClassPathXmlApplicationContext context) {
        System.out.println("\n=== Scope ===");

        Pet dog1, dog2;
        dog1 = context.getBean("myPet2", Pet.class);
        dog2 = context.getBean("myPet2", Pet.class);
        System.out.println("scope=\"singleton\" Objects are same:\n" + dog1 + "\n" + dog2);

        Pet parrot1, parrot2;
        parrot1 = context.getBean("myPet3", Pet.class);
        parrot2 = context.getBean("myPet3", Pet.class);
        System.out.println("scope=\"prototype\" Objects are different:\n" + parrot1 + "\n" + parrot2);
    }
}
