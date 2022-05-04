package learn_annotation_context_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;


@Configuration
@PropertySource("classpath:app.properties")
public class MyConfig  {

    @Bean(name = "myPet1")
    @Scope("singleton")
    public Pet cat() {
        return new Cat();
    }

    @Bean
    @Scope("prototype")
    public Pet dog() {
        return new Dog();
    }

    @Bean
    public Person person() {
        return new Person(dog());
    }
}
