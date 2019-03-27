package com.springcloud;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientUploadFeignApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaClientUploadFeignApplication.class).web(WebApplicationType.SERVLET).run(args);
	}

}
