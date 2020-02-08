package core_java;

public class DataType {
    public static void main(String[] args) {
        int[] ls =new int[]{12,32,544};
        arrayPointer(ls);
        System.out.println(ls[0]);

    }

    public static void tt(int[] ls1){
        int[] ls={12,43,343,90,23};  //数组定义和python的差别,python中是[],';'结束，句法严格
        ls1 = ls;  // System.out.println(tt_ls[0]);   //数组也是应用，是Object的一种，我的天啊。
        byte a,b; // 连续声明，但是不能连续赋值
        a = (byte)32;
        b=43;  // byte这种整形数据，都不怎么用来，其实大量的处理字节流文件，还有short，由大到小是可以自动的
        byte f=(byte)(b +a);  // 强制类型转换。byte类型不使用数学运算符。+会自动将byte转换为int
        System.out.println(a);
        for(int i=0;i<ls.length;i++){ // python中使用in,

        }
    }
    public static void typeTest(){
        Object obj1,obj2;
        obj1 =new Object();
        obj2 =new Object();
        System.out.println(obj1.equals(obj2));
        String str1=new String("dfs");
        String str2=new String("dfs");
        System.out.println(str1 == str2);
        String st3 = "China";
        String st4 = "China";  //在语法上同str1是不一样的,这个只是把指针给他。
        System.out.println(st3 == st4);

    }
    public static void arrayPointer(int[] ls){
        ls[0] = 23;

    }


}
