package jvm;

import java.io.*;

/**
 * ClassLoader是一个没有抽象方法的抽象类。
 * 看完书上的类后自己独立实现一个
 */
public class PathClassLoaderTest {
    public static void main(String[] args) {
        String path =PathClassLoaderTest.class.getClassLoader().getResource("").toString();
        System.out.println(path);
        path = path.substring(path.indexOf("/")+1);
        // 出现了两种文件分隔符。。
        PathClassLoader pcl =new PathClassLoader(path);
        pcl.myLoadClass("jvm.GetStreamTest");   // 直接通过包名和类名就可以找到。
        System.out.println("It's over");
    }

}
class PathClassLoader extends ClassLoader{
    String classpath;
    PathClassLoader(String classpath){
        this.classpath =classpath;
    }
    protected Class<?> myLoadClass(String name){
        try
        {
        return super.loadClass(name);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    protected Class<?> myPathLoadClass(String name){
        byte[] data = getData(name);
        if(data!=null){
            return super.defineClass(name,data,0,data.length);
        }
        else {
            try {
                 return super.loadClass(classpath + File.separatorChar + name.replace(".", File.separator) + ".class");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return null;
    }
    private byte[] getData(String name){
        // name只是给定这个类名，还要加path名。File.pathSeperatorChar是只文件的分隔符
        // InputStream只有一个空构造器，是一个抽象类
        // ByteArrayInputStream是以字节流为构造器参数
        // replaceAll就是正则表达式了，CharSequence是一个接口，子类有String，StringBuilder等
        String filepath = (classpath+ File.separatorChar+name).replace(".",File.separator)+".class";
        System.out.println(filepath);
        try{
            InputStream is= new FileInputStream(new File(filepath));
            byte[] bytes =new byte[1024];
            ByteArrayOutputStream baos =new ByteArrayOutputStream();
            int num =0;
            while ((num=is.read(bytes))!=-1){
                baos.write(bytes,0, num);
            }
            return baos.toByteArray();
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("文件不存在");
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}

