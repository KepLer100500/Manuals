package org.kepler.di;

import org.kepler.di.model.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);
        
        var parrot = (Parrot)context.getBean("parrot");
        parrot.setName("Gumi-chan");
        
        var personAutowiredField = (PersonAutowiredField)context.getBean("personAutowiredField");
        personAutowiredField.setName("Petya");
        System.out.println(personAutowiredField);
        
        var personAutowiredConstructor = context.getBean(PersonAutowiredConstructor.class);
        personAutowiredConstructor.setName("Vanya");
        System.out.println(personAutowiredConstructor);
        
        var personAutowiredSetter = context.getBean(PersonAutowiredSetter.class);
        personAutowiredSetter.setName("Sergey");
        System.out.println(personAutowiredSetter);
        
        var contextQualifier = new AnnotationConfigApplicationContext(ConfigQualifier.class);
        
        var person = contextQualifier.getBean("person");
        System.out.println(person);
        
        var personQualifierConstructor = context.getBean(PersonQualifierConstructor.class);
        personQualifierConstructor.setName("Dendy");
        System.out.println(personQualifierConstructor);
    }

}
