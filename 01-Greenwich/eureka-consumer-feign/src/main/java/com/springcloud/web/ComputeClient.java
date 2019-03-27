package com.springcloud.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-client")
public interface ComputeClient {

	@GetMapping("/add")
	String add();
	
}
