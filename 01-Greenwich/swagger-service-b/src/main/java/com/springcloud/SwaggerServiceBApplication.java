package com.springcloud;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SwaggerServiceBApplication {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(SwaggerServiceBApplication.class).web(WebApplicationType.SERVLET).run(args);
	}
	
}
