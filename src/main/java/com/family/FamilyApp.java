package com.family;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FamilyApp {

    public static void main(String[] args) {
        SpringApplication.run(FamilyApp.class, args);
    }
}
