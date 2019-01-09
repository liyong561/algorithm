package leetcode;

import javax.print.attribute.HashDocAttributeSet;
import java.util.Arrays;
import java.util.HashSet;

public class HashCodeUnique {
    public static void main(String[] args) {
          String st1=new String("ddd");
          String st2="fff";
          String st3=new String("ddd"); //会认为是一样。细节，String类重写了hashCode函数。
        /*
         ==就是比较的内存地址。
         hashcode还要重写成员对象的方法，
         equals()方法返回true，则认为两个对象相等。
         eauals(){
            return hashcode()&&**;
         }
         */
        HashSet<String> hs=new HashSet<>();
        System.out.println(hs.add(st1));
        System.out.println(hs.add(st2));
        System.out.println(st1.hashCode());
        System.out.println(st3.hashCode());
        System.out.println(hs.add(st3));
        Student stu=new Student("liyong",32);
        Student stu1=new Student("liyong01",54);
        Student stu2=new Student("liyong02",32);
        HashSet<Student> hss=new HashSet<>();
        System.out.println(hss.add(stu));
        System.out.println(hss.add(stu1));
        System.out.println(hss.add(stu2));
        short[] arr=new short[2];
        // Arrays.fill(arr,0);

    }
    public static void print(){

    }
}
class Student{  //表明类的名称，没别的了。
    String name;
    int age;
    public Student(String name,int age){
          this.name=name;
          this.age=age;
    }
}