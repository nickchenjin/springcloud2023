package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Classname:OrderFeignMain80
 * Package:org.example
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/12 - 19:59
 * @Version: V1.0
 */

@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class , args);
    }
}
