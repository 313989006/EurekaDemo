package com.mxk.eurekaserver8300;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eurekaserver8300Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurekaserver8300Application.class, args);
    }

}
