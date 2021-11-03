package com.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author gaorun
 * @Description
 * @create 2021-11-02 14:37
 */
@SpringBootApplication
@EnableEurekaServer
public class EurakaServer02Application {

	public static void main(String[] args) {
		SpringApplication.run(EurakaServer02Application.class);
	}
}
