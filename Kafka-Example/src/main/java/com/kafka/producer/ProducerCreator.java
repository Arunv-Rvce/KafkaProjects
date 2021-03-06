package com.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import com.kafka.config.KafkaConfigConstants;

public class ProducerCreator {
	
	public static Producer<Long, String> createProducer(){
		Properties config = new Properties();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfigConstants.KAFKA_BROKERS);
		config.put(ProducerConfig.CLIENT_ID_CONFIG, KafkaConfigConstants.CLIENT_ID);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		return new KafkaProducer<>(config);
	}

}
