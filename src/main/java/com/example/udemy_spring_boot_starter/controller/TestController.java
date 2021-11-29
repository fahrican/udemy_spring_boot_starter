package com.example.udemy_spring_boot_starter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String displayText() {
        return "Helooo World!!";
    }
}
