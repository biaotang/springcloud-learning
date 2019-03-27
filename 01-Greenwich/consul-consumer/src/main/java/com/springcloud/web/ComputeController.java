package com.springcloud.web;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ComputeController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/consume", method = RequestMethod.GET)
	public String add() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("consul-client");
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/add";
		logger.info("url:" + url);
		String result = restTemplate.postForObject(URI.create(url), null, String.class);
		return result;
	}
	
}
