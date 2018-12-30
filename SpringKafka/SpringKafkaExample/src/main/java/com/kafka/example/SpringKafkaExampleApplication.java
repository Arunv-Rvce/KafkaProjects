package com.kafka.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kafka.producer.Sender;

@SpringBootApplication
public class SpringKafkaExampleApplication implements CommandLineRunner{

	private static Logger LOGGER = LoggerFactory.getLogger(SpringKafkaExampleApplication.class);

	public static void main(String[] args) {
		try {
			SpringApplication.run(SpringKafkaExampleApplication.class, args).close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
    private Sender sender = new Sender();

    @Override
    public void run(String... strings) throws Exception {
        sender.sendMessage("Spring Kafka and Spring Boot Configuration Example");
    }
}
