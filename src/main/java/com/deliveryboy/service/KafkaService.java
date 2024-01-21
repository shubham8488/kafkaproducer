package com.deliveryboy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	public boolean updateLocation(String location) {
		
		kafkaTemplate.send("location-update-topic", location);
		return true;
	}
}
