package com.example.demo.controller;

import com.example.demo.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    ConfigService configService;

    @RequestMapping("/name")
    public String getName(){
        return configService.getName();
    }



}
