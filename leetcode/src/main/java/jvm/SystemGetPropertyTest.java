package jvm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * System.getProperty(),获取环境的运行信息。
 */
public class SystemGetPropertyTest {
    public static void main(String[] args) {
        test02();
    }
    public static void test(){
        // 操作系统提供的接口
        System.out.println(System.getenv());
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("core_java"));
        // 自定义系统变量
        System.setProperty("name","liyong");
    }
    public static void test02(){
        // 看了一下file的继承关系，好像没有继承什么。Reader和Wirter好像没有什么关系，
        Properties properties =new Properties();
        try {
            properties.load(SystemGetPropertyTest.class.getResourceAsStream("/static/ss.properties"));
            // multi_exception是se7的语法，意思是异常对象之间没有继承关系
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(properties.getProperty("name"));
    }
}
