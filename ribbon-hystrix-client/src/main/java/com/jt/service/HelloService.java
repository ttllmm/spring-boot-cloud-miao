package com.jt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
	@Autowired
	private RestTemplate template;
	//当前方法调用时，跑出的问题，或者异常，可以利用熔断的注解
	//实现错误的调用，错误的方法执行错误出现后的逻辑
	//fallbackMethod，在当前方法出现问题后，当前类会调用erroHi同名方法
	//传递给sayHello的所有参数，会一并交给errorHi处理
	@HystrixCommand(fallbackMethod="errorHi")
	public String sayHello(String name) {
		ResponseEntity<String> entity = template.getForEntity("http://service-hi/hi?name="+name, 
				String.class);
		String response=entity.getBody();
		//response,hi haha, im from 8091/8092
		
		return response;
	}
	
	public String errorHi(String name){
		//写消息到rabbitmq
		//返回当前的错误报信
		return "hi，"+name+",bagayalu,有错误";
	}

}
