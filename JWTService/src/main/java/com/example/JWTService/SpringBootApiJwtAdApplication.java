package com.example.JWTService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootApiJwtAdApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootApiJwtAdApplication.class, args);
    }

}
