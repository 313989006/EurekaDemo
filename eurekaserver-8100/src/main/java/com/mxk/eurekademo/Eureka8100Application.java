package com.mxk.eurekademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka8100Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka8100Application.class, args);
    }

}
