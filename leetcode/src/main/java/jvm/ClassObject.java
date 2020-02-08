package jvm;

/**
 * 看看Class对象的方法和返回值
 */
public class ClassObject {
    public static void main(String[] args) throws Exception {
        testMethod();
    }
    public static void testMethod() throws Exception{
        String name = GetStreamTest.class.getName();
        // 返回类对象，由类对象调用类的构造方法生成实例对象,forName是全限定名，否则project会找不到该类
        Class<?> get =Class.forName(name);
        // get由Class对象转换为GetStreamTest对象，getConstructor是一个可以接受可变参数个数的，当然也可以为空Class<?>... parameterTypes)
        GetStreamTest getStreamTest = (GetStreamTest)get.getConstructor().newInstance();
        getStreamTest.greet();
        AConstructor ac = (AConstructor)Class.forName("jvm.AConstructor").getConstructor(String.class,Integer.class).newInstance("liyong",32);
        ac.say();
        System.out.println(name);
    }
}
class AConstructor{
    String name;
    Integer age;
    public AConstructor(){

    }
    public AConstructor(String name,Integer age){
        this.name = name;
        this.age = age;
    }
    public void say(){
        System.out.println("I am "+name+ "，I am "+age+ "years old");
    }
}
