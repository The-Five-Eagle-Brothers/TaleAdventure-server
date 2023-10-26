package com.example.taleadventure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TaleAdventureApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaleAdventureApplication.class, args);
    }

}
