package com.kafka.entity;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageObjectDeserializer implements Deserializer<MessageObject> {

	@Override
	public void close() {

	}

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {

	}

	@Override
	public MessageObject deserialize(String topic, byte[] byteData) {
		ObjectMapper mapper = new ObjectMapper();
		MessageObject messageObject = null;
		try {
			messageObject = mapper.readValue(byteData, MessageObject.class);
		} catch (Exception exception) {
			System.out.println("Error in deserializing bytes " + exception);
		}

		return messageObject;
	}

}
