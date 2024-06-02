package com.quiz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuizSeriveApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuizSeriveApplication.class, args);
	}
}
