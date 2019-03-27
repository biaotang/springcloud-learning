package com.springcloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputeController {
	
	@Autowired
	ComputeClient computeClient;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return computeClient.add() + " in eureka-consumer-feign";
	}
	
}
