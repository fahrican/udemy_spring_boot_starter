package com.example.udemy_spring_boot_starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UdemySpringBootStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UdemySpringBootStarterApplication.class, args);
    }
}
