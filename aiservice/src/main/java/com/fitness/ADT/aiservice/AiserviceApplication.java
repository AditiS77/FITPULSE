package com.fitness.ADT.aiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class AiserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiserviceApplication.class, args);
	}

	// Creates a WebClient.Builder bean for GeminiService to use.
	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}

}
