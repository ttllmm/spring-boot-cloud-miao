package com.jt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableConfigServer
/*@Controller*/
public class StarterConfig {
	/*@Value("${name}")
	private String name;
	@RequestMapping("config")
	@ResponseBody
	public String getName(){
		return name;
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(StarterConfig.class, args);
	}
}
