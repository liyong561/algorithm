package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 通过这个对象获取配置的信息
 */
@Service
public class ConfigService {
    // 这个注解的作用应该是先去本地配置文件中找，本地配置文件告诉它去另一个服务中找，
    /**
     * https://github.com/liyong561/algorithm//config-file/myService.yml'}]},在bootstrap中，自动合成了该路径。
     */
    @Value("${name}")
    private String name;

    public String getName(){
        return name;
    }
}
