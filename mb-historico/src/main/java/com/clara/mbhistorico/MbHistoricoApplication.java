package com.clara.mbhistorico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MbHistoricoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbHistoricoApplication.class, args);
	}

}
