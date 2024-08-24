package com.abdulazizpr.springboot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcRepositories(basePackages = {"com.abdulazizpr.springboot.repository"})
@SpringBootApplication(scanBasePackages = "com.abdulazizpr.springboot")
public class SpringBootPersonalApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootPersonalApplication.class, args);
    }
}
