package com.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author gaorun
 * @Description
 * @create 2021-11-02 16:27
 */
@SpringBootApplication
public class ServiceConsumerApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplateLb() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceConsumerApplication.class);
	}
}
