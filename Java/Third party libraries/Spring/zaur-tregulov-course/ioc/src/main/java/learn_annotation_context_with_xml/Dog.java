package learn_annotation_context_with_xml;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
@Scope("prototype")
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
