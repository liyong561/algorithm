package ex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 在ex的类要定义扫描包才能生效。
 */
@Configuration
public class TestBean {
    @Bean
    public Cat cat(){
        return new Cat();
    }
}
