package com.mxk.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients     // 开启 Feign 客户端
@SpringBootApplication
public class ConsumerDemo8090Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDemo8090Application.class, args);
    }

}
