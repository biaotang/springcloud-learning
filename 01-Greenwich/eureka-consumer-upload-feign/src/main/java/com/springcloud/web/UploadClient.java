package com.springcloud.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

@FeignClient("eureka-client-upload-feign")
public interface UploadClient {

	@PostMapping(value="/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	String uploadFile(@RequestPart(value="file") MultipartFile file);
	
	class MultipartSupportConfig {
		
		@Bean
		public Encoder feignFormEncoder() {
			return new SpringFormEncoder();
		}
		
	}
}
