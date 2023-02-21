package org.kepler.ioc;

import lombok.*;
import org.kepler.ioc.model.*;
import java.util.function.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Data
class Cat {
    private String name;
}

public class App {
    public static void main(String[] args) {
        System.out.println("Run");

        var context = new AnnotationConfigApplicationContext(Config.class);
        var parrot = context.getBean("my-parrot");
        ((Parrot)parrot).setName("chik-chirik-epta");
        System.out.println(parrot);

        var contextAutoScan = new AnnotationConfigApplicationContext(ConfigAutoScan.class);
        var anotherParrot = contextAutoScan.getBean(Parrot.class);
        System.out.println(anotherParrot);

        Cat cat = new Cat();
        cat.setName("Olivka !!!");
        Supplier<Cat> catSupplier = () -> cat;
        context.registerBean("olivka", Cat.class, catSupplier, bc -> bc.setPrimary(true));
        var catFromContext = context.getBean("olivka");
        System.out.println(catFromContext);

    }
}
