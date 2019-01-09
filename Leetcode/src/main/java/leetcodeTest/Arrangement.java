package leetcodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrangement {
    public static void main(String[] args) {
        test02();
    }
    public static List<List<Integer>> arrange(){
        //输出0-n-1的全排列，这是一个最基本的问题，一般采用回溯法
        List<List<Integer>> lls=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        backtrack(lls,ls,0,10);
        return  lls;
    }
    public static void backtrack(List<List<Integer>> lls,List<Integer> ls,int start,int n){
        //回溯算法输出全排列的方法有点难以理解，其实看看自己怎么写全排列的问题就知道了。
          if (ls.size()==n){
              lls.add(ls);
              return;
          }
          for(int i=start;i<n;i++){
              if(!ls.contains(i)){
                  ls.add(i);
              }
              backtrack(lls,ls,i+1,n); //start的作用是什么？
              ls.remove(ls.size()-1);
          }
    }
    public static void test02(){
        Boolean[][] boo=new Boolean[2][2];
        for(int i=0;i<2;i++){
            Arrays.fill(boo[i],false);
        }
        Boolean[][] boo1=boo.clone(); //这个克隆是浅克隆，源对象更改后，复制对象也会改变。
        Boolean[][] boo2=new Boolean[2][2];

                System.arraycopy(boo,0,boo2,0,2); //二维数组也适用,但是这也属于浅克隆
        Boolean[][] boo3=new Boolean[2][2];
        for(int i=0;i<2;i++){
            System.arraycopy(boo[i],0,boo3[i],0,2);
        }
        boo[1][1]=true;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                System.out.println(boo3[i][j]);
            }

        }

        List<Boolean[][]> ls=new ArrayList<>(); //Boolean总感觉怪怪的。
    }
}
