package com.example.demo.controller;

import com.example.demo.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @Autowired
    RestService restService;


    @RequestMapping(value = "/hi")
    //RequestParam中的参数
    public String sayHi(@RequestParam(required = false,defaultValue = "") String name){
        return restService.sayHi(name);
    }
}
