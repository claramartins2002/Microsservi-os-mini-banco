package com.clara.mbeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MbEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbEurekaServerApplication.class, args);
	}

}
