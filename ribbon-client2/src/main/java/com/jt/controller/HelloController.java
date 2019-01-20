package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
	@Autowired
	private RestTemplate template;
	//测试方法，hi
	@RequestMapping("hi")
	public String sayHello(String name){
		//url访问的服务地址 service-hi
		//name=haha  http://service-hi/hi?name=haha
		String hi = template.getForObject("http://service-hi/hi?name="+name, 
				String.class);
		return "谭良谋ribbon:"+hi;
//		ResponseEntity<String> entity = template.getForEntity("http://service-hi/hi?name="+name, 
//				String.class);
//		String response=entity.getBody();
		//response,hi haha, im from 8091/8092
		
//		return response;
	}
}
