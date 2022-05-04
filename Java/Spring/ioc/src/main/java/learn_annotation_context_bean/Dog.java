package learn_annotation_context_bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Dog implements Pet {
    @Override
    public void say() {
        System.out.println("Dog say: Gav - gav");
    }

    @PostConstruct
    public void init() {
        System.out.println("# Dog init!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("# Dog destroy!");
    }

    public Dog() {
        System.out.println("@@@ Dog bean is created");
    }
}
