package com.example.demo.cc;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 可以通过@ ConfigurationProperties注解，将配置信息读取到配置文件中。所以这个注解很强大。
 * @ Component会自动注册为Context的bean，
 */
@Component
@ConfigurationProperties(prefix = "dt")
public class DataConfig {
    private String url;
    private String name;
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DataConfig{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
