package leetcodeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapTest {
    public static void main(String[] args) {
        tenToTwo(90);
    }
    public static void test01(){
        HashMap<String,List<String>> ans=new HashMap<>(); //List的接口实现不需要我来弄。
        ans.put("sss",new ArrayList<>());//最常用的三个方法
        ans.get("sss");
        ans.values(); //突出了键值对数据结构的精髓。
    }
    public double myPow(double x, int n) {
        long N = n;
        if( N < 0) {
            x = 1/x;            N = -N;
        }
        double ans = 1;
        double current_product = x;

        for(long i = N; i > 0; i /= 2) {
            if(i % 2 == 1)
                ans = ans * current_product;
            current_product = current_product * current_product;//非常不容易理解
        }
        return ans;
    }
    public static String tenToTwo(int n) {
        int j = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i /= 2) {
            if (i % 2 == 1) sb.append("1");
            else {
                sb.append("0");
            }
        }
        sb.reverse();
        String st = new String(sb);
        System.out.println(st);
        return st;
    }
}

