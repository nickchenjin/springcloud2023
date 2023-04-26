package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Classname:PaymentHystricxMain8001
 * Package:org.example
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/12 - 22:17
 * @Version: V1.0
 */

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystricxMain8001 {
    public static void main(String[] args) {

        SpringApplication.run(PaymentHystricxMain8001.class , args);

    }
}
