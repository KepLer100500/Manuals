package org.kepler;

import org.kepler.aspect.AspectOrderedFirst;
import org.kepler.aspect.AspectOrderedSecond;
import org.kepler.aspect.AspectOrderedThird;
import org.kepler.aspect.MyPointcut;
import org.springframework.context.annotation.*;


@Configuration
@PropertySource("classpath:app.properties")
@EnableAspectJAutoProxy
public class MyConfig {

    @Bean(name = "uniLibrary")
    public Library uniLibrary() {
        return new UniLibrary();
    }

    @Bean(name = "schoolLibrary")
    public Library schoolLibrary() {
        return new SchoolLibrary();
    }

    @Bean(name = "book")
    public Book book() {
        return new Book();
    }

    @Bean
    public AspectOrderedFirst aspectOrderedFirst() {
        return new AspectOrderedFirst();
    }

    @Bean
    public AspectOrderedSecond aspectOrderedSecond() {
        return new AspectOrderedSecond();
    }

    @Bean
    public AspectOrderedThird aspectOrderedThird() {
        return new AspectOrderedThird();
    }

    @Bean
    public MyPointcut myPointcut() {
        return new MyPointcut();
    }

    @Bean
    public Student student() {
        return new Student();
    }

    @Bean
    public University university() {
        return new University();
    }

}