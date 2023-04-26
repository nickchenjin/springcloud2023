package org.example.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Classname:ApplicationContextConfig
 * Package:org.example.config
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/10 - 19:20
 * @Version: V1.0
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
   // @LoadBalanced
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
