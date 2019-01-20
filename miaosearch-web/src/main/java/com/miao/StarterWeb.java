package com.miao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller

public class StarterWeb {
	
	public static void main(String[] args) {
		SpringApplication.run(StarterWeb.class, args);
	}
	
	@RequestMapping("/")
	public String goIndex(){
		return "index";
	}
	
}
