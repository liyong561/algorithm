package jvm;

import java.io.*;

/**
 * 在一些框架中，都会在启动时加载一些config文件，或者其他文件，比如mybatis中的mapper文件，也是加载进去的。
 * 所用的方法：getResourceAsStream（）,getResource()
 *
 */
public class GetStreamTest {
    public static void main(String[] args) throws IOException {
        new GetStreamTest().greet();
        // System.out.println(GetStreamTest.class.getClass().getClassLoader()); oot ClassLoader加载，所以返回null
        System.out.println(A.class.getClassLoader());
        System.out.println(A.class.getClassLoader().getParent());
    }
    public void greet(){
        System.out.println("Hello,Everyone\n");
    }
    public static void test() throws IOException{
        // 发现怎么读取InputStream文件也是一个问题,其是一个bstract class,面向接口编程，is对象具体是什么对象呢?
        // java.io.ByteArrayInputStream
        //InputStream is =GetStreamTest.class.getResourceAsStream("");
        InputStream is =GetStreamTest.class.getResourceAsStream("/static/a4.txt");
        FileOutputStream fos =new FileOutputStream(new File("a4.txt"));
        byte[] bytes =new byte[1024];
        while (is.read(bytes)!=-1){
            fos.write(bytes);
        }
        System.out.println();
    }

}
class A{
    String slogan="Some day, you will become a person you want";
    public void show(){
        System.out.printf("Our slogan is"+slogan);
    }
        }