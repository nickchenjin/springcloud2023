package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classname:myrule
 * Package:com.rule
 * Description:
 *
 * @Author:NickChJ
 * @Create:2023/4/12 - 15:00
 * @Version: V1.0
 */
@Configuration
public class Myrule {

    @Bean
    public IRule myRule()
    {
        return new RandomRule();
        //return new RoundRobinRule();
    }

}
