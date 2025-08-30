package com.rodrigosousa.oraclecloud_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OraclecloudMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OraclecloudMicroserviceApplication.class, args);
	}

}
