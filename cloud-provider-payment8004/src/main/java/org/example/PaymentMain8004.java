package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Classname:PaymentMain8004
 * Package:org.example
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/11 - 17:11
 * @Version: V1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class , args);
    }
}
