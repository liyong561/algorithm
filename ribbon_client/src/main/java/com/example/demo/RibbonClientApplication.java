package com.example.demo;

import com.example.demo.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RibbonClientApplication {

	public static void main(String[] args) {
		ApplicationContext act=SpringApplication.run(RibbonClientApplication.class, args);


	}

}

/*
http://localhost:8761/eureka/默认的注册地址,没有这个Ribbon也会报错，比如孩子回家后就会找妈妈（爸爸)；

 */