package com.example.pagaassgn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PagaAssgnApplication {

    public static void main(String[] args) {
        SpringApplication.run(PagaAssgnApplication.class, args);
    }

}
