package com.eureka;

import com.netflix.loadbalancer.RandomRule;
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

	//全局指定负载均衡策略
	@Bean
	public RandomRule randomRule() {
		return new RandomRule();
	}

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
