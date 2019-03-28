package com.springcloud.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "数值")
public class Num {

	@ApiModelProperty(value="数值a", example="1", required=true)
	private Integer a;

	@ApiModelProperty(value="数值b", example="1", required=true)
	private Integer b;

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public Integer getB() {
		return b;
	}

	public void setB(Integer b) {
		this.b = b;
	}
	
}
