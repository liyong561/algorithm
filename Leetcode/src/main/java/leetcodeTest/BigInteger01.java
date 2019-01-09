package leetcode;

public class BigInteger01 {
    public static void main(String[] args) {
        System.out.println();
    }

    public String multiply(String num1, String num2) {
        //这个要熟悉乘法的计算过程，并且使用分布计算的方法。i位数和j位数相乘，结果的最小位为i+j-1位。
        int len1 = num1.length(), len2 = num2.length();
        int len = len1 + len2 + 1; //最大的长度
        int[] sum = new int[len]; //用于存储结果
        for (int i = 0; i < sum.length; i++) {
            sum[i] = 0; // 初始化以下。
        }
        // 顺序关系难于处理
        /*
        for(int i=num1.length-1;i>=0;i--){
         for(int j=num1.length-1;j>=0;j--){
             int m1=Integer.parseInt(num1.substring(i,i+1));
             int m2=Integer.parseInt(num2.substring(j,j+1));
             //以下步骤处理比较繁琐，但是没有其他办法，BigInteger也许就是这样处理的
             int sum1=m1*m2;
             if()
         }
     }
     */
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) { //这种计算顺序还是会影响到后面的结果。
                int m1 = Integer.parseInt(num1.substring(len1 - i - 1, len1 - i));
                int m2 = Integer.parseInt(num2.substring(len2 - j - 1, len2 - j));
                int sum1 = m1 * m2 + sum[len - i - j - 1];
                int mod = sum1 % 10;
                int div = sum1 / 10;
                sum[len - i - j - 1] += mod;
                sum[len - i - j - 2] += div; //对前面的数进行修正，从低位到高位方便进位处理。会向波浪一样向前推进。
                System.out.println(sum[len - i - j - 2]);
            }
        }
        for (int i = 0; i < sum.length; i++) {
            System.out.println(sum[i]); // 初始化以下。
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (; i < len; i++) {
            if (sum[i] != 0) break;

        }
        for (int j = i; j < len; j++) {
            sb.append(sum[j]); //这个i错了
        }
        return new String(sb);
    }
}
