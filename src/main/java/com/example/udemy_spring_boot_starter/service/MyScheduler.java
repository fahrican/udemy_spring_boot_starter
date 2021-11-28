package com.example.udemy_spring_boot_starter.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MyScheduler {

    @Scheduled(cron = "0 0/5 * 1/1 * ?")
    public void executeEveryMinute() {
        System.out.println(new Date());
    }
}
