package com.kepler.proxy;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class KafkaProducer {

    public void sendMessage() {
        String bootstrapServers = "192.168.162.187:9092";
        String topic = "test_topic";

        // Настройки для Producer
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Создание Producer
        org.apache.kafka.clients.producer.KafkaProducer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(properties);

        // Создание и отправка сообщения
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "hello", "Kafka from Java");
        producer.send(record);

        // Закрытие Producer
        producer.close();
    }
}
