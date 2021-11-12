package com.eureka;

import com.netflix.loadbalancer.RandomRule;
import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author gaorun
 * @Description
 * @create 2021-11-02 16:27
 */
@SpringBootApplication
@EnableFeignClients
public class ServiceConsumerApplication {

//	@Bean
//	public RandomRule randomRule() {
//		return new RandomRule();
//	}

//	@Bean
//	public Logger.Level getLogo() {
//		return Logger.Level.FULL;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceConsumerApplication.class);
	}
}
