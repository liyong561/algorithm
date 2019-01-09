package leetcodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SolveNQueens {
    public static void main(String[] args) {
        EightQueen.nqueen();
    }
    public static void test02(){
        Solution sl=new Solution(); //怎么使用java类取计算一个操作的耗时。
        long start=System.currentTimeMillis(); //以毫秒为单位
        sl.solveNQueens(8);  //n=16竟然内存溢出，怎么回事？new操作就是用到内存的地方，虽然垃圾回收机制会回收。
        long end=System.currentTimeMillis();
        System.out.println("耗时"+(end-start)+"毫秒");
    }
}
class Solution {
    public List<List<String>> solveNQueens(int n) {
        //也可归为查找符合要求的排列问题。
        //但是真正要去做的时候还是遇到各种各样的问题。
        List<Boolean[][]> ls=new ArrayList<>();
        Boolean[][] boo1=new Boolean[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(boo1[i],false); //这个函数只能填充二维数组
        }
        trackback(ls,boo1,0,n);
        List<List<String>> lss=new ArrayList<>();
        for(Boolean[][] boo:ls){
            List<String> ls1=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(boo[i][j]==true){ //不是1
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                ls1.add(new String(sb));
            }
            lss.add(ls1);
        }
        return lss;
    }
    //泛型中怎么加入矩阵？
    public void trackback(List<Boolean[][]> ls,Boolean[][] boo,int row,int n){

        if(row==n){//基本数据类型在复制其副本存在问题。
            Boolean[][] boo1=new Boolean[n][n];
            for(int i=0;i<n;i++){
                System.arraycopy(boo[i],0,boo1[i],0,n);
            }
            ls.add(boo1);
            return;
        }
        for(int i=row;i<n;i++){
            int j=0;
            for(;j<n;j++){
                if(!isValid(boo,i,j)){
                    continue;
                }
                boo[i][j]=true;//满足不互相攻击的条件才可以置1
                trackback(ls,boo,i+1,n);
                boo[i][j]=false;
                System.gc();
            }
            if(j>=n){
                return; //返回调用函数
            }
        }

    }
    public boolean isValid(Boolean[][] boo,int i,int j){
        for(int j1=0;j1<i;j1++){
            if(boo[j1][j]==true){
                return false;
            }
        }
        for(int j1=0;(j+j1)<boo.length&&(i-j1)>=0;j1++){
            if(boo[i-j1][j+j1]==true){
                return false;
            }
        }
        for(int j1=0;(i-j1)>=0&&(j-j1)>=0;j1++){
            if(boo[i-j1][j-j1]==true){
                return false;
            }
        }
        return true;
    }
}
 class EightQueen {
    private static final short N=14;        //使用常量来定义，方便之后解N皇后问题
    private static int count=0;            //结果计数器

    public static void nqueen() {
        Date begin =new Date();
        //初始化棋盘，全部置0
        short chess[][]=new short[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                chess[i][j]=0;
            }
        }

        putQueenAtRow(chess,0);
        Date end =new Date();
        System.out.println("解决 " +N+ " 皇后问题，用时：" +String.valueOf(end.getTime()-begin.getTime())+ "毫秒，计算结果："+count);
    }

    private static void putQueenAtRow(short[][] chess, int row) {
        /**
         * 递归终止判断：如果row==N，则说明已经成功摆放了8个皇后
         * 输出结果，终止递归
         */
        if(row==N){
            count++;
            System.out.println("第 "+ count +" 种解：");
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    System.out.print(chess[i][j]+" ");
                }
                System.out.println();
            }
            return;
        }

        short[][] chessTemp=chess.clone();

        /**
         * 向这一行的每一个位置尝试排放皇后
         * 然后检测状态，如果安全则继续执行递归函数摆放下一行皇后
         */
        for(int i=0;i<N;i++){
            //摆放这一行的皇后，之前要清掉所有这一行摆放的记录，防止污染棋盘
            for(int j=0;j<N;j++)
                chessTemp[row][j]=0;
            chessTemp[row][i]=1;

            if( isSafety( chessTemp,row,i ) ){
                putQueenAtRow(chessTemp,row+1); //在这里调用了函数本身
            }
        }
    }

    private static boolean isSafety(short[][] chess,int row,int col) {
        //判断中上、左上、右上是否安全
        int step=1;
        while(row-step>=0){
            if(chess[row-step][col]==1)                //中上
                return false;
            if(col-step>=0 && chess[row-step][col-step]==1)        //左上
                return false;
            if(col+step<N && chess[row-step][col+step]==1)        //右上
                return false;

            step++;
        }
        return true;
    }
}