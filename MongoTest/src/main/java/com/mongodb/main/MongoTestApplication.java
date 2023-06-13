package com.mongodb.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.services.UserRepo;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = UserRepo.class)
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.mongodb.*")

public class MongoTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoTestApplication.class, args);
	}

}
