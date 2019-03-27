package com.springcloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ComputeController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return restTemplate.getForObject("http://eureka-client/add", String.class) + " in eureka-consumer-ribbon";
	}
	
}
