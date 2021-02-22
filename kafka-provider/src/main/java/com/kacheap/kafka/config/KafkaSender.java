package com.kacheap.kafka.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class KafkaSender {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private Gson gson = new GsonBuilder().create();

	// 发送消息方法
	public void send(String topic, String message) {
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("id", System.currentTimeMillis());
		msg.put("msg", message);
		msg.put("sendTime", new Date());
		System.err.println("+++++++++++++++++++++  message = " + gson.toJson(msg));
		kafkaTemplate.send(topic, gson.toJson(msg));
	}
}