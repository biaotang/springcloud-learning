package com.springcloud;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@EnableBinding
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumerRibbonHystrixApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaConsumerRibbonHystrixApplication.class).web(WebApplicationType.SERVLET).run(args);
	}
	
}
