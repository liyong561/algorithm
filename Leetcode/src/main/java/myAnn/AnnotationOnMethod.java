package myAnn;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 总结，注解就像是给类打一个标签，可以由程序员自定义干什么，相比于继承和组合，减少了代码的耦合。
 * annotation同意可以用在method上，基本思想是获得类的Method对象，就看可以想获取类注解一样了。
 * Annotation是一个接口，返回的Annotation是一个什么样的对象呢？不过类型为Annotation没有有价值的信息，还是得变成注解对象。
 * Class.getName()和Class.getSimpleName(),想想有时候jvm就是使用name来加载的，也是很神奇啊。
 */
public class AnnotationOnMethod {
    public static void main(String[] args) {
         // Annotation[] ans = TestA.class.getAnnotations();给方法注释后，这个类获取不到。
        Annotation[] ans = TestA.class.getDeclaredMethods()[0].getAnnotations();
        System.out.println(ans.length);
        for(Annotation an: ans){
            System.out.println(an.getClass().getName());
            System.out.println(an.annotationType().getCanonicalName());
            System.out.println(an.annotationType());

        }
    }

}

/**
 * @ interface 就相当于声明一个注解,perform这个注解，啥也不干，定义一个注解，要使用java的元注解，使用起来相当简单。
 * 理解为实现Annotation接口的方法也可以，毕竟涉及到jvm的工作机制
 */
@Retention(RetentionPolicy.RUNTIME)
@interface Perform{
     //这个注解啥也不做。
}

/**
 * 使用没有属性的注解，就不用定义属性的吗名称。
 */
class TestA{
    @Perform
    public void say(){
        System.out.println("please keep in studying");
    }

}