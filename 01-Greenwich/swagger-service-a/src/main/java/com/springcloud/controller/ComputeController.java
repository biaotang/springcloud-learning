package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entity.Num;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "Compute", description = "计算操作")
public class ComputeController {
	
	@Autowired
	DiscoveryClient discoveryClient;

	@ApiOperation(value = "算法相加")
	@GetMapping("/service-a")
	public String add(
			@ApiParam(value = "数值a",required = true) @RequestParam(value = "pageIndex", defaultValue = "1") Integer a,
            @ApiParam(value = "数值b",required = true) @RequestParam(value = "pageSize", defaultValue = "1") Integer b) {
		String services = "Service: " + discoveryClient.getServices();
		System.out.println(a + " + " + b + " = " + (a+b));
		return services;
	}
	
	@ApiOperation(value = "算法相加")
	@ApiImplicitParam(name = "num", value = "数值", required = true, dataType = "Num")
	@GetMapping("/service-a-1")
	public String add(@RequestBody Num num) {
		String services = "Service: " + discoveryClient.getServices();
		System.out.println(num.getA() + " + " + num.getB() + " = " + (num.getA()+num.getB()));
		return services;
	}
	
}
