package com.cole.kafkademo.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {
	
	@Value("${spring.kafka.topic-name.in}")
	private String topicNameIn;
	
	@Value("${spring.kafka.topic-name.out")
	private String topicNameOut;

	private KafkaTemplate<String, String> kafkaTemplate;
	
	public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	@PostMapping("/")
	public void publish(@RequestBody MessageRequest request) {
		kafkaTemplate.send(topicNameIn, request.message());
	}
}
