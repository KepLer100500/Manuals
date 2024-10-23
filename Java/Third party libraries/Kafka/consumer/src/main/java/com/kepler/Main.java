package com.kepler;

import com.kepler.proxy.KafkaConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@ComponentScan
public class Main {
    public static void main(String[] args) {
        log.error("consumer");
        var context = new AnnotationConfigApplicationContext(Main.class);
        KafkaConsumer producer = context.getBean(KafkaConsumer.class);
        producer.readMessage();
    }
}