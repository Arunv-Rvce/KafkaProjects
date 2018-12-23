package com.kafka.entity;

import java.util.Date;

public class MessageObject {
	
	private String message;
	private Date createdDate;
	
	public MessageObject(String message) {
		this.message = message;
		this.createdDate =  new Date();
	}

	@Override
	public String toString() {
		return "MessageObject [message=" + message + ", createdDate=" + createdDate + "]";
	}
	
	

}
