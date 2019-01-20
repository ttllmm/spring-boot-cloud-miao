package com.jt.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-hi")
public interface HelloService {
	
	@RequestMapping(value="hi",method=RequestMethod.GET)
	String sayHello(@RequestParam(value="name") String name);
}
