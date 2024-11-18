package com.spring_project.mealplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MealplannerApplication {
	public static void main(String[] args) {
		SpringApplication.run(MealplannerApplication.class, args);
	}
}