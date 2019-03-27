package com.springcloud;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.springcloud.web.UploadClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EurekaConsumerUploadFeignApplicationTests {

	@Autowired
	private UploadClient uploadClient;
	
	@Test
	public void contextLoads() {
		File file = new File("MT.txt");
		DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file", MediaType.TEXT_PLAIN_VALUE, true, file.getName());
		
		try (InputStream is = new FileInputStream(file); 
				OutputStream os = fileItem.getOutputStream()){
			IOUtils.copy(is, os);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MultipartFile mutiFile = new CommonsMultipartFile(fileItem);
		System.out.println(uploadClient.uploadFile(mutiFile));
	}

}
