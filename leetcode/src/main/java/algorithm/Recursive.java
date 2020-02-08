package algorithm;

public class Recursive {
    public static void main(String[] args) {
        String str="qwert";
        System.out.println(str.charAt(10)); // 会报错,exception,不会再编译时检查出来。
    }
    // 使用对象的状态来记住状态，
    int i=0;
    String st="China";
    public char getChar(){
        if(i<st.length()) {
            i++;
            return st.charAt(i - 1);
        }
        else return '\0';

    }
    /**
     * 使用逆序输出字符串，非尾递归，这种情况非常适合来遍历二叉树，因为他记住了原理的路径。
     * 递归一般都是使用stack结构，用stack来描述递归非常的直观。
     */
    public void reverse1(){
        char c = getChar();
        if(c!='\0'){   //基本类型的判空和object的判空
            reverse1();
            System.out.println("the char is "+c);
        }

    }

    /**
     * 这种尾递归非常好用loop来代替。
     * @param i 参数
     */
    public void tail(int i){
        if(i>0){
            System.out.println("the number is "+i);
            tail(i-1); //
        }
    }
    /**
     * java解决八皇后问题，以y轴的数组坐标输出
     * 因为使用递归问题，返回值得设计很重要。
      */



}
