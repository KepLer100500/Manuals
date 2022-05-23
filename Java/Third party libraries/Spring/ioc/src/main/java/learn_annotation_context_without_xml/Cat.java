package learn_annotation_context_without_xml;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component("myPet1")
// @Component // default bean id -> cat
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
