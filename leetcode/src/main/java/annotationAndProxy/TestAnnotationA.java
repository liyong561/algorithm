package annotationAndProxy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 注解的属性，也叫field，没有method，以无形参的方法声明，其类型是8种基本类型，外加接口，类，注解，及它们的数组。可能还有String？文档没有
 * 说的很清楚，https://docs.oracle.com/javase/specs/jls/se8/html/jls-9.html#jls-9.6.1
 * 接下来怎么使用注解才是最重要的。
 * 使用java的放射，获得Annotation对象，java语言都给你定义好了，就可以获得注解的信息。
 *
 */
public class TestAnnotationA {
    public static void main(String[] args) {
        TestAA ta =new TestAA();
        // 为什么不能写Class<TestAA> ?这是一种严谨，如果ta只是TestAA的一个子类的对象呢？这种面向对象的编程在java中非常常见。
        Class<? extends TestAA> taClazz = ta.getClass();
        System.out.println("TestAA use the TestAnnotationA1 :"+taClazz.isAnnotationPresent(TestAnnotationA1.class));
        TestAnnotationA1 testAnnotationA1 = taClazz.getAnnotation(TestAnnotationA1.class);  // 指定获取哪个类型的注解。
        System.out.println("id:"+testAnnotationA1.id());  // 这种获得属性的方式很奇怪。
        System.out.println("msg:"+testAnnotationA1.msg());

    }
}
// 没有Retention，默认策略为RetentionPolicy.class,则通过对象已经获取不到注解对象了。
@Retention(RetentionPolicy.RUNTIME)
@interface TestAnnotationA1{
    int id();
    String msg();
}
@TestAnnotationA1(id =2,msg="hello,annotation")
class TestAA{

}