package com.manguetech.edu.barbeariaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BarbeariaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BarbeariaApiApplication.class, args);
    }

}
