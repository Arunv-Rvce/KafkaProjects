package com.kafka.producer;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.log4j.Logger;

import com.kafka.config.KafkaConfigConstants;
import com.kafka.entity.MessageObject;;

public class ProducerApplication {
	
	public static Logger logger = Logger.getLogger("sample");
	
	public static int messageNum = 0;
	
	public static void main(String args[]) {
		runProducer();
	}
	
	public static void runProducer() {
		Producer<Long, String> producer = ProducerCreator.createProducer();
		System.out.println("Producer Created");
		for(int i=0; i<KafkaConfigConstants.MESSAGE_COUNT; i++) {
			MessageObject messageObject = new MessageObject("Message No:" + ++messageNum);
			ProducerRecord<Long, String> producerRecord = new ProducerRecord<Long, String>(KafkaConfigConstants.TOPIC_NAME, messageObject.toString());
			
			try {
				RecordMetadata metadata = producer.send(producerRecord).get();
				System.out.println("Message Sent:" + messageObject.toString() + " Metadata:" + metadata);
			} catch (Exception e) {
				System.out.println("Error occured:" + e.getMessage() );
			}
		}
	}
	
}
