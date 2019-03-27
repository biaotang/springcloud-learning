package com.springcloud.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputeController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		List<String> services = client.getServices();
		logger.info("services:" + services);
		return "this is Eureka add method (1)";
	}
	
}
