package com.example.demo.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name){
        if(StringUtils.isBlank(name)) {
            return "hi,  I am eureka client, port="+port;
        }
        return "hi,  I am eureka client="+name+",port="+port;
    }
    // 方法重载，参数不同。@RequestMapping("/hi"),这明显是url相同，会发生mapping错误。

    @RequestMapping("/hello")
    public String hello(){
        return "who are you?";
    }
}
