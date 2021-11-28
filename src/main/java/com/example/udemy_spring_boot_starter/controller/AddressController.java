package com.example.udemy_spring_boot_starter.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/address/")
public class AddressController {

    @GetMapping("displayCity")
    public String displayCity() {
        return "Hello from Berlin City";
    }
}
