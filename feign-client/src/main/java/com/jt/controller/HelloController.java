package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.service.HelloService;

@RestController
public class HelloController {
	@Autowired
	private HelloService helloService;
	//测试案例
	@RequestMapping("hi")
	public String sayHello(String name){
		String hello=helloService.sayHello(name);
		return "FEIGN："+hello;
	}
}
