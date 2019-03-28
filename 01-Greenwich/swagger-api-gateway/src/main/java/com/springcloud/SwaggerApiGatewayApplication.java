package com.springcloud;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringCloudApplication
public class SwaggerApiGatewayApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SwaggerApiGatewayApplication.class).web(WebApplicationType.SERVLET).run(args);
	}
	
}
