package com.abdulazizpr.springboot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;


@EnableR2dbcRepositories
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class SpringBootPersonalApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootPersonalApplication.class, args);
    }

}
