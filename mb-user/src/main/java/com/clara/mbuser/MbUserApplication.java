package com.clara.mbuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MbUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbUserApplication.class, args);
	}

}
