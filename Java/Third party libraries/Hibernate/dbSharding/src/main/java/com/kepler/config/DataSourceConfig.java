package com.kepler.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Value("${db.ip}")
    private String ip;

    @Bean
    public DataSource shardDataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>();

        DataSource shard1 = DataSourceBuilder.create()
                .url("jdbc:postgresql://" + ip + ":5433/shard1")
                .username("user")
                .password("pass")
                .build();

        DataSource shard2 = DataSourceBuilder.create()
                .url("jdbc:postgresql://" + ip + ":5434/shard2")
                .username("user")
                .password("pass")
                .build();

        DataSource shard3 = DataSourceBuilder.create()
                .url("jdbc:postgresql://" + ip + ":5435/shard3")
                .username("user")
                .password("pass")
                .build();

        targetDataSources.put(0, shard1);
        targetDataSources.put(1, shard2);
        targetDataSources.put(2, shard3);

        ShardRoutingDataSource routingDataSource = new ShardRoutingDataSource();
        routingDataSource.setTargetDataSources(targetDataSources);
        routingDataSource.setDefaultTargetDataSource(shard1); // fallback
        return routingDataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource shardDataSource,
                                                                       EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(shardDataSource)
                .packages("com.kepler.model")
                .build();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
