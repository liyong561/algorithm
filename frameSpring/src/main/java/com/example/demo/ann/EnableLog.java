package com.example.demo.ann;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 有关于注解的一些信息
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyImportSelector.class)
public @interface EnableLog {
    String name() default "liyong";
    int age() default 23;
}
