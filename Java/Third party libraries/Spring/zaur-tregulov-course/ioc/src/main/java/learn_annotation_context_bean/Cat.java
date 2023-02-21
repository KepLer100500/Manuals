package learn_annotation_context_bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Cat implements Pet {
    @Override
    public void say() {
        System.out.println("Cat say: Mur - mew");
    }

    public Cat() {
        System.out.println("@@@ Cat bean is created");
    }

    @PostConstruct
    public void init() {
        System.out.println("# Cat init!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("# Cat destroy!");
    }
}
