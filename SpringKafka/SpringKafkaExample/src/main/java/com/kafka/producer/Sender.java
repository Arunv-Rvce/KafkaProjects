package com.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
	private static final Logger LOGGER = LoggerFactory.getLogger("KafkaProducer.class");
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${application.kafka.topic}")
	private String topic = "exampletopic";
	
	public void sendMessage(String message) {
		kafkaTemplate.send(topic, message);
	}

}
