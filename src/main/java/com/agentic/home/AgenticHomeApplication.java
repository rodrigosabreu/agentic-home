package com.agentic.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EntityScan(basePackages = "com.agentic.home.domain.model")
@EnableJpaRepositories(basePackages = "com.agentic.home.infrastructure.persistence.jpa")
@EnableScheduling
public class AgenticHomeApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AgenticHomeApplication.class, args);
    }
}