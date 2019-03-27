package com.springcloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class ConsumerService {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
			})
	public String compute(String... arg) {
		return restTemplate.getForObject("http://eureka-client/add", String.class);
	}
	
	public String fallback(String... arg) {
		return "fallback";
	}
	
}
