package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    public String sayHi(String name){
        //去调用其他服务吗？这个url的格式很值得探究
        //获取服务id的服务列表
        List<ServiceInstance> instances=discoveryClient.getInstances("service-hi");
        System.out.println("uri是这样的："+instances.get(0).getUri().toString());  // 认识一下uri是什么：http://192.168.1.215:8763

        return this.restTemplate.getForObject("http://service-hi/hi?name="+name,String.class);
    }

}
