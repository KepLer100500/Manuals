package learn_annotation_context_without_xml;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
@Scope("singleton")
public class Parrot implements Pet {
    @Override
    public void say() {
        System.out.println("Chik - chirik!");
    }

    @PostConstruct
    public void init() {
        System.out.println("# Parrot init!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("# Parrot destroy!");
    }

    public Parrot() {
        System.out.println("@@@ Parrot bean is created");
    }
}
