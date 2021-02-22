package com.kacheap.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kacheap.kafka.config.KafkaSender;

@RestController
@RequestMapping("/message/")
public class MessageController {
	@Autowired
	private KafkaSender kafkaSender;

	@GetMapping("send/{num}/{topic}/{message}")
	public String send(@PathVariable int num, @PathVariable String topic, @PathVariable String message) {
		for (int i = 0; i < num; i++) {
			kafkaSender.send(topic, message + "_" + i);
		}
		
		return "success";
	}
}
