package com.kacheap.kafka.config;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaReceiver {

	@KafkaListener(topics = { "hello", "ynshun", "soga" })
	public void listen(ConsumerRecord<?, ?> record) {

		Optional<?> kafkaMessage = Optional.ofNullable(record.value());

		if (kafkaMessage.isPresent()) {
			Object message = kafkaMessage.get();
			// System.err.println("+++++++++++++++++++++  record = " + record);
			System.err.println("+++++++++++++++++++++  message = " + message);
		}
	}
}