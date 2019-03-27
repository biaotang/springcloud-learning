package com.springcloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ComputeController {
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/add";
		return restTemplate.getForObject(url, String.class);
	}
	
}
