package com.mxk.demo.config;

import com.mxk.demo.rule.CustomRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CodeConfig
 * @Description TODO
 * @Author ma.kangkang
 * @Date 2020/12/12 17:15
 **/
@Configuration
public class CodeConfig {


    // 指定负载均衡方式访问(默认轮询)，如果注释掉，consumer调用 providor 会报500：java.net.UnknownHostException: product-service
//    @LoadBalanced
//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

    // 指定自定义负载均衡策略
    @Bean
    public IRule loadBalanceRule(){
        List<Integer> ports = new ArrayList<>();
        ports.add(8083);
        return new CustomRule(ports);
    }
}
