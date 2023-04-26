package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Hello world!
 *
 * @author Administrator
 */

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient (name = "cloud-payment-service" , configuration = com.rule.Myrule.class)
public class OrderMain80
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderMain80.class, args);
    }
}
