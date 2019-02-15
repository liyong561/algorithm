package com.example.demo.config;

import com.example.demo.entity.Person;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

/*
@Configuration在@SpringBoot注解的所在包和子包都可以扫描得到，没有这个注解是不行的。
 */
@Configuration
public class ConfigBean {
    @Bean
    @Scope("singleton")
    public Person getPerson(){
        return new Person();
        //Person person=(Person)act.getBean("getPerson");
        //		System.out.println(person.getName());
    }
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
