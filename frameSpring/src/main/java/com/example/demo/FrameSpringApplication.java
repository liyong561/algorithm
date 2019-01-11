package com.example.demo;

import com.example.demo.ann.EnableLog;
import com.example.demo.cc.AsyncBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import ex.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ SpringBootApplication 会扫描当前包和子包,所以所有类都定义在com.example.demo下面，这是一条有点奇怪的规则，见@ ComponentScan,
 * 会先去apt，处理注释。
 */
// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
 //@Import(ex.Dog.class)
@EnableLog
//@EnableAsync  // EnableAsync会加载一个类到内存，或者容器。
public class FrameSpringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(FrameSpringApplication.class, args);
		System.out.println(context.getBean(ObjectMapper.class));//这个类默认自动装配了,这个是spi
		//  System.out.println(context.getBean(ObjectReader.class));
		System.out.println(context.getBean(Dog.class));
		Gson gson =context.getBean(Gson.class);
		System.out.println(gson);
		/**
		 * Gson对象spring容器自动装配了，spring-boot-autoconfigure
		 * # AutoConfigureJson auto-configuration imports
		 * org.springframework.boot.test.autoconfigure.json.AutoConfigureJson=\
		 * org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration,\
		 */
		System.out.println(gson.toJson(100));
		AsyncBean asyncBean = context.getBean(AsyncBean.class);
		asyncBean.f2(20);
		asyncBean.f1(15);
	}

}

