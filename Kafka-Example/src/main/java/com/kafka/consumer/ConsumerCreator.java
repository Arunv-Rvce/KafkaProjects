package com.kafka.consumer;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import com.kafka.config.KafkaConfigConstants;

public class ConsumerCreator {
	
	public static Consumer<Long, String> createConsumer(){
		Properties config = new Properties();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfigConstants.KAFKA_BROKERS);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConfigConstants.GROUP_ID_CONFIG);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		config.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, KafkaConfigConstants.MAX_POLL_RECORDS);
		config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, KafkaConfigConstants.OFFSET_RESET_LATEST);
		
		Consumer<Long, String> consumer = new KafkaConsumer<>(config);
		consumer.subscribe(Collections.singletonList(KafkaConfigConstants.TOPIC_NAME));
		return consumer;
	}

}
