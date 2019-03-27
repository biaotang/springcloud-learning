package com.springcloud;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsulConsumerApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ConsulConsumerApplication.class).web(WebApplicationType.SERVLET).run(args);
	}

}
