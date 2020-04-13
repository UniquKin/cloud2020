package com.atguigu.myrule;

import com.atguigu.springcloud.lb.RoundRobinRule_ZRC;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RoundRobinRule_ZRC();
    }
}
