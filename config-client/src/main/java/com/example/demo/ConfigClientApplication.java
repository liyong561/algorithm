package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigClientApplication {
	/*
	每个微服务可能会运行多个服务实例，就像是类和对象的关系，这时需要不同的配置信息，这就是config server的一个应用场景。
	配置client从通常的意义看，也知识调用了server的服务，那么，怎么让其他的服务在运行之前都从配置中心拉取文件呢？
	该服务使用了config-server中的配置文件，即是对config应用产生了依赖。
	 */

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

}

