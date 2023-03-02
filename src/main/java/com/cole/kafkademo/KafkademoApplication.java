package com.cole.kafkademo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import com.cole.kafkademo.Domain.Flight;

@SpringBootApplication
public class KafkademoApplication {
	
	@Value("${spring.kafka.topic-name.in}")
	private String topicNameIn;
	
	@Value("${spring.kafka.topic-name.out")
	private String topicNameOut;

	public static void main(String[] args) {
		SpringApplication.run(KafkademoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner cmdLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			Flight flt1 = new Flight("000", "DFW", "SDF");
			Flight flt2 = new Flight("565", "ANC", "SDF");
			
			kafkaTemplate.send(topicNameIn, flt1.returnJSON().toString());
			kafkaTemplate.send(topicNameIn, flt2.returnJSON().toString());
			};
	}
}








