package com.example.demo.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstanceController {
    @Autowired
    EurekaClient eurekaClient;
    @RequestMapping("/info")
    public String info(){
        return eurekaClient.getAllKnownRegions().toString();
    }
    @RequestMapping("/eurekaClient")
    public EurekaClient getEurekaClient() {
        return eurekaClient;
    }
}
