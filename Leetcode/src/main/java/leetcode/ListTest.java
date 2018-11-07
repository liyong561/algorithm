package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class ListTest
{
    public static void main(String[] args) {
        test01();
        short[] sh=new short[4];
        for(int i=0;i<sh.length;i++){
            sh[i]=(short)i; //
        }
        short[] sh1=change(sh);
        for(int i=0;i<sh1.length;i++){
            System.out.println(sh1[i]);
        } //改变了数组
        TreeNode root=new TreeNode(3);
        sumNumbers(root);
        // visit01();
    }
    public static void listmap(){
        List<Integer> ls=new ArrayList<>();
        ls.addAll(Arrays.asList(23,24,25));//是一个函数
        ls.replaceAll(new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return 4;
            }
        }); //一个apply方法，使用lamda表达式
        ls.replaceAll((integer -> 5));//参数->返回值，就这么简单.
    }
   public static void test01(){
        //ls：1，2，3和3,2,1是一样的吗？
       List<Integer> ls1=new ArrayList<>(Arrays.asList(1,2,3));
       List<Integer> ls2=new ArrayList<>(Arrays.asList(3,2,1));
       System.out.println(ls1.equals(ls2));

   }

  public static short[]  change(short[] sh){
       sh[1]=99;
       return sh;
   }
    public static int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        List<List<Integer>> lls=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        List<Integer> ls2=new ArrayList<>();
        for(int i=0;i<5;i++){
            ls2.add(i);
        }
        int sum=0;
        lls.add(ls2);
        visit(root,lls,ls);
        for(List ls1:lls){ //类型转换的问题
            StringBuilder sb=new StringBuilder();
            for(Object num:ls1){  //泛型在类型转换时的问题。
                Integer ig=(Integer)num;
                sb.append(num);
            }
            int count=Integer.parseInt(new String(sb));
            sum+=count;
        }
        return sum;
    }
    public static void visit(TreeNode root,List lls,List<Integer> ls){
        if(root==null){
             List ls1=new ArrayList<Integer>();
             ls1.addAll(ls);
            // lls.add(new ArrayList<Integer>().addAll(ls));这个错误很隐蔽\
            lls.add(ls1);
            return;
        }
        ls.add(root.val);
        visit(root.left,lls,ls);
        ls.remove(ls.size()-1);
        visit(root.right,lls,ls);
    }
    public static void visit01(){
        List<List<Integer>> lls=new ArrayList<>();
        List<Integer> ls1=new ArrayList<>();
        List<Integer> ls2=new ArrayList<>();
        for(int i=0;i<5;i++){
            ls1.add(i);
            ls2.add(i);
        }
        lls.add(ls1);
        lls.add(ls2);
        for(List ls:lls){
            for(Object num:ls){
                System.out.println(num);
            }
        }
    }
}
class TreeNode {
    int val;
     TreeNode left;
    TreeNode right;
      TreeNode(int x) { val = x; }
  }