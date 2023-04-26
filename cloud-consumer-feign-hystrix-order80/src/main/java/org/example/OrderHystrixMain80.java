package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.swing.*;

/**
 * Classname:OrderHystrixMain80
 * Package:org.example
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/12 - 23:17
 * @Version: V1.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableCircuitBreaker
public class OrderHystrixMain80 {
    public static void main(String[] args) {

        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
