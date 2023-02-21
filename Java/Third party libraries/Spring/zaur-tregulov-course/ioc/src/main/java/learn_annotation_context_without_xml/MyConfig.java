package learn_annotation_context_without_xml;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("learn_annotation_context_without_xml")
@PropertySource("classpath:app.properties")
public class MyConfig  {

}
