package com.cole.kafkademo.Listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

	@KafkaListener(topics = "messageTopic", groupId = "foo")
	void listener(String data) {
		System.out.println("Listener recieved: " + data + " successfully!");
	}
}
