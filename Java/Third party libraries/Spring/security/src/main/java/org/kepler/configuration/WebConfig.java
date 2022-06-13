package org.kepler.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import java.beans.PropertyVetoException;


@Configuration
@ComponentScan("org.kepler")
@EnableWebMvc
public class WebConfig {

    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean(name = "dataSource")
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass("org.postgresql.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:postgresql://127.0.0.1/test");
        comboPooledDataSource.setUser("postgres");
        comboPooledDataSource.setPassword("postgres");
        return comboPooledDataSource;
    }

}
