package com.kepler;

import com.kepler.proxy.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@ComponentScan
public class Main {
    public static void main(String[] args) {
        log.error("producer");
        var context = new AnnotationConfigApplicationContext(Main.class);
        KafkaProducer producer = context.getBean(KafkaProducer.class);
        producer.sendMessage();
    }
}