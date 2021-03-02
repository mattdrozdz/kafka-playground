package com.example.kafkademo;

import static com.example.kafkademo.KafkaDemoApplication.SAMPLE_TOPIC;

import com.example.kafkademo.model.SampleEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SampleKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @EventListener(ApplicationReadyEvent.class)
    public void process() throws Exception {
        for (int i = 0; i < 10; i++) {
            log.info("sending kafka event");
            var event = new SampleEvent(String.format("Event no %d with timestamp %s", i, LocalDateTime.now()));
            var serializedEvent = objectMapper.writeValueAsString(event);
            var result = kafkaTemplate.send(SAMPLE_TOPIC, serializedEvent);
            result.completable().get(5, TimeUnit.SECONDS);
        }
    }

}
