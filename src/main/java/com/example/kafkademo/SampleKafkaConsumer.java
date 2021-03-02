package com.example.kafkademo;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SampleKafkaConsumer {

    // @KafkaListener(topics = "sampleTopic", errorHandler = "kafkaErrorHandler")
    @KafkaListener(topics = "sampleTopic")
    public void handle(ConsumerRecord<String, String> event) {
    // @SendTo("another-topic")
    // public void handle(@Payload String event) { // + @Header/@Headers
        log.info("Handling kafka event {}", event);
    }

}
