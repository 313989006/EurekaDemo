package com.mxk.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer     // 开启 Eureka Server 功能
public class Eurekaserver8000Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurekaserver8000Application.class, args);
    }

}
