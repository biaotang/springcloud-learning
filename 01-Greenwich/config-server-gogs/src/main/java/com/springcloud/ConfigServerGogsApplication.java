package com.springcloud;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServerGogsApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigServerGogsApplication.class).web(WebApplicationType.SERVLET).run(args);
	}

}
