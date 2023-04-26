package org.example.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Classname:FeignConfig
 * Package:org.example.config
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/12 - 21:24
 * @Version: V1.0
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }
}
