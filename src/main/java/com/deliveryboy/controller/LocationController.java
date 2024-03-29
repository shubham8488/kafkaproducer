package com.deliveryboy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryboy.service.KafkaService;

@RestController
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private KafkaService kafkaService;

	@PostMapping("/test")
	public ResponseEntity<?> test() {
		return new ResponseEntity<>(Map.of("Message", "Test page loaded"), HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<?> update() {
		String location = Math.random() + "";
		this.kafkaService.updateLocation(location);
		System.out.println("Location Updated");
		return new ResponseEntity<>(Map.of("Message", "Location Updated by kafka producer"), HttpStatus.OK);
	}

}
