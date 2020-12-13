package com.mxk.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName CodeConfig
 * @Description TODO
 * @Author ma.kangkang
 * @Date 2020/12/12 17:15
 **/
@Configuration
public class CodeConfig {


    // 指定负载均衡方式访问(默认轮询)，如果注释掉，consumer调用 providor 会报500：java.net.UnknownHostException: product-service
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
