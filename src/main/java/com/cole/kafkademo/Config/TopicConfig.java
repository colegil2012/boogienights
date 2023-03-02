package com.cole.kafkademo.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {
	
	@Value("${spring.kafka.topic-name.in}")
	private String topicNameIn;
	
	@Value("${spring.kafka.topic-name.out")
	private String topicNameOut;
	
	@Bean
	public NewTopic createTopicIn() {
		return TopicBuilder.name(topicNameIn).build();
	}
	
	@Bean
	public NewTopic createTopicOut() {
		return TopicBuilder.name(topicNameOut).build();
	}
}
