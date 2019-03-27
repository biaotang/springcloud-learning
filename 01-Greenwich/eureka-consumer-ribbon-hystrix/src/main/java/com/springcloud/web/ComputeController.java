package com.springcloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputeController {

	@Autowired
	ConsumerService consumerService;
	
	@GetMapping("/add")
	public String add() {
		for (int i = 0; i<200; i++) {
			System.out.println(consumerService.compute());
		}
		return consumerService.compute();
	}
	
}
