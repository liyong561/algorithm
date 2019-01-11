package com.example.demo.cc;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

/**
 * 测试一下这个异步方法。
 * @ Enable中开启对异步方法的支持。
 */
@Service
@EnableAsync
public class AsyncBean {
    @Async
    public void f1(Integer n){
        for(int i=0;i<n;i++){
            System.out.println("I come from function f1:"+i);
        }
    }
    @Async // 这个注解不可少。
    public void f2(Integer n){
        for(int i=0;i<n;i++){
            System.out.println("I come from function f2:"+i);
        }
    }
}
