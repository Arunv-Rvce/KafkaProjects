package com.kafka.consumer;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import com.kafka.config.KafkaConfigConstants;

public class ConsumerApplication {
	
	public static void main(String args[]) {
		startConsumer();
	}
	
	public synchronized static void startConsumer() {
		Consumer<Long, String> consumer = ConsumerCreator.createConsumer();
		
		for(int i=0; i<KafkaConfigConstants.MESSAGE_COUNT; i++) {
			ConsumerRecords<Long, String> consumerRecords = consumer.poll(1000l);
			if (consumerRecords.count() == 0) {
				System.out.println("No Records Found");
			}
			
			consumerRecords.forEach(record -> {
				System.out.println("Record Key " + record.key());
				System.out.println("Record value " + record.value().toString());
				System.out.println("Record partition " + record.partition());
				System.out.println("Record offset " + record.offset());
			});
			consumer.commitAsync();
		}
		consumer.close();
	}

}
