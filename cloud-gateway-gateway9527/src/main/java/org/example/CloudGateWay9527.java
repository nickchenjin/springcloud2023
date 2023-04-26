package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Classname:CloudGateWay9527
 * Package:org.example
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/24 - 17:05
 * @Version: V1.0
 */

@SpringBootApplication
@EnableEurekaClient
public class CloudGateWay9527 {
    public static void main(String[] args) {
        SpringApplication.run(CloudGateWay9527.class,args);
    }
}
