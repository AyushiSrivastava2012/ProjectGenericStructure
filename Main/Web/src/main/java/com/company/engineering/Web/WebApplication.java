package com.company.engineering.Web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@Configuration
@EnableMongoRepositories(basePackages="com.company.engineering.Repositories")
public class WebApplication {

	
			public static void main(String[] args) {
				SpringApplication.run(WebApplication.class, args);
			}
	}