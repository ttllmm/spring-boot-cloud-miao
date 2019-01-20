package com.jt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("hi")
	@ResponseBody
	public String sayHello(String name){
		return "hi,"+name+", i am from port "+port;
	}
}
