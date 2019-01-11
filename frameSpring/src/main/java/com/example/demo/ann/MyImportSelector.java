package com.example.demo.ann;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 和EnableLog类相互引用，不知道是一种什么设计模式。
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 构造函数没有参数，importingClassMetadata是怎么调用的呢？作者说获取注解的属性信息？
        System.out.println(importingClassMetadata.getAllAnnotationAttributes(EnableLog.class.getName()));

        return new String[]{"ex.Dog"};
    }
}
