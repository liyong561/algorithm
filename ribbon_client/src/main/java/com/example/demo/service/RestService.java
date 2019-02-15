package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    @Autowired
    private RestTemplate restTemplate;

    public String sayHi(String name){
        //去调用其他服务吗？这个url的格式很值得探究
        return this.restTemplate.getForObject("http://service-hi/hi?name="+name,String.class);
    }

}
