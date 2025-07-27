package com.kepler.config;

import com.kepler.model.Signal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class Config {
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("192.168.162.144", 6379);
        config.setUsername("default");
        config.setPassword("admin");
        return new JedisConnectionFactory(config);
    }

    @Bean
    public RedisTemplate<Signal, Object> redisTemplate() {
        RedisTemplate<Signal, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

}
