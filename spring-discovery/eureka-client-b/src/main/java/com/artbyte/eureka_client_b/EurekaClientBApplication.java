package com.artbyte.eureka_client_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class EurekaClientBApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientBApplication.class, args);
	}

}
