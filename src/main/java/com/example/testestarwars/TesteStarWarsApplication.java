package com.example.testestarwars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.example.testestarwars.repository"})
public class TesteStarWarsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesteStarWarsApplication.class, args);
    }

}
