package com.cts.feature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan
public class FeatureServer {
	
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "feature-server");
		
		SpringApplication.run(FeatureServer.class, args);
	}

}
