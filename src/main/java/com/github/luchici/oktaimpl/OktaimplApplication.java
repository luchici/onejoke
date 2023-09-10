package com.github.luchici.oktaimpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OktaimplApplication {

    public static void main(String[] args) {
        SpringApplication.run(OktaimplApplication.class, args);
    }
}
