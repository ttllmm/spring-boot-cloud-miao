//package com.jt;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//@RefreshScope
//@Controller
//public class TestController {
//	@Value("${spring.redis.nodes}")
//	private String name;
//	
//	@RequestMapping("test")
//	@ResponseBody
//	public String getName(){
//		return name;
//	}
//}
