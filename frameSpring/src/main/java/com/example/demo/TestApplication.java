package com.example.demo;

import com.example.demo.cc.DataConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 为了学习方便，自定义的启动类
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class TestApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(TestApplication.class,args);
        Environment env = context.getEnvironment();  // Environment是一个接口，实际返回的是ConfigurableEnvironment类
        System.out.println(env);
        DataConfig dataConfig =context.getBean(DataConfig.class);
        System.out.println(dataConfig.toString());
    }
}
