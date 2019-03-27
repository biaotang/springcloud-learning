package com.springcloud.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@RestController
public class ConfigController {
	
	@Value("${config.repo}")
	String info;
	
	@GetMapping(value="/read")
	public String read() {
		return info;
	}
	
}
