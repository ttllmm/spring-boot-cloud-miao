package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class StarterRibbon {
	public static void main(String[] args) {
		SpringApplication.run(StarterRibbon.class, args);
	}
	@Bean
	@LoadBalanced //启用负载均衡，做轮训访问
	public RestTemplate getRes(){
		return new RestTemplate();
	}
}
