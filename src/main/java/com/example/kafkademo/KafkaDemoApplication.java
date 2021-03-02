package com.example.kafkademo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class KafkaDemoApplication {

	public static final String SAMPLE_TOPIC = "sampleTopic";

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}

	@Bean
	public NewTopic topic1() {
		return TopicBuilder.name("topic_1")
			.partitions(2)
			.replicas(1)
			.build();
	}

	@Bean
	public NewTopic topic2() {
		return TopicBuilder.name("topic_2")
			.partitions(1)
			.replicas(1)
			.compact()
			.build();
	}

	@Bean
	public NewTopic sampleTopic() {
		return TopicBuilder.name(SAMPLE_TOPIC)
			.partitions(1)
			.replicas(1)
			.build();
	}


}
