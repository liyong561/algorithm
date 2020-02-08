package algorithm;

/**
 * 达到的效果，小的在前，大的在后。
 * 有一些最基本的思想，比如在一次遍历过程中找到最大（小)的，这就是插入排序的最基本原理了。
 */
public class SortTest {
    public static void main(String[] args) {
        int[] ls1 = {12, 323, 23, 32, 143, 2321, 90};
        //qickSort(ls1, 0, ls1.length - 1);
        chooseSort(ls1);
        for(int n:ls1){
            System.out.println(n);
        }

    }

    /**
     * 基于数组的插入排序,顺序，和脚标的顺序一致。
     *
     * @param ls 数组
     * @return 排序后的数组
     */
    public static int[] insertSort(int[] ls) {
        // i,j,k的索引。
        int temp;
        for (int i = 1; i < ls.length; i++) {
            // temp  = ls[i];
            /**
             * for(;j>=0&&temp<a[j];j--){
             *   a[j+1]=a[j]; //将大于temp的值整体后移一个单位
             *  }看看这种写法，非常的优雅。
             */
            for (int j = 0; j < i; j++) {
                // 排好序了的序列 length == i;
                if (ls[j] > ls[i]) {
                    temp = ls[i];
                    // 后面的数依次后移,强烈建议画图理解
                    for (int k = i; k > j; k--) {
                        ls[k] = ls[k - 1];
                    }
                    ls[j] = temp;
                }
            }
        }
        return ls;
    }

    /**
     * 快速排序，使用了枢轴的概念,将大问题化为小问题，使用了交换的思想。快速排序使用率递归。部分数组，low,high;
     * 调用的时候，low=0,high= ls.length-1;数轴的值并不是中间值，而是假定第一个。
     * 冒泡:即两个泡，这里面也有枢轴的概念,
     *
     * @param ls
     * @return 分别从初始序列“6 1 2 7 9 3 4 5 10 8”两端开始“探测”。先从右往左找一个小于6的数，再从左往右找一个大于6的数，然后交换他们
     * 跳出循环的条件，哨兵相遇。
     */
    public static void qickSort(int[] ls, int low, int high) {
        if (low >= high)
            return;
        int key = ls[low];
        int i = low;
        int j = high;
        while (i < j) {
            // 为什么要有等于号？
            while ((ls[j] > key) && (i < j)) {
                j--;
            }
            while ((ls[i] < key) && (i < j)) {
                i++;
            }
            if (i < j) {
                int temp = ls[j];
                ls[j] = ls[i];
                ls[i] = temp;

            }
        }
        ls[low] = ls[i];
        ls[i] = key;

        qickSort(ls, low, i - 1);
        qickSort(ls, i + 1, high);

    }

    //传入的ls是一个副本，ls就是一个引用。
    public static void swap(int[] ls, int idx1, int idx2) {
        int temp = ls[idx1];
        ls[idx1] = ls[idx2];
        ls[idx2] = temp;
        int start = 3;
        int i = start, j;//初始化i,j
    }

    private static void QuickSort(int[] array, int start, int end) {
        if (start < end) {
            int key = array[start];//初始化保存基元
            int i = start, j;//初始化i,j
            for (j = start + 1; j <= end; j++) {    // i会一直小于j
                if (array[j] < key)//如果此处元素小于基元，则把此元素和i+1处元素交换，并将i加1，如大于或等于基元则继续循环
                {
                    int temp = array[j];
                    array[j] = array[i + 1];
                    array[i + 1] = temp;
                    i++;
                }

            }
            array[start] = array[i];//交换i处元素和基元
            array[i] = key;
            QuickSort(array, start, i - 1);//递归调用
            QuickSort(array, i + 1, end);

        }
    }
    public static void chooseSort(int[] ls){
        for(int i=0;i<ls.length;i++){
            int temp = ls[i];
            int k =i;
            for(int j=i+1;j<ls.length;j++){
                if(ls[j]<temp){
                    temp=ls[j];
                    k =j;
                }
            }
            //移动
            for(int j=k;j>i;j--){
                ls[k] =ls[k-1];
            }
            ls[i] =temp;
        }
    }

    /**
     * 归并排序，将若干个有序子序列，归并到一个子序列。
     * 思想，两个序列的哨兵同步前进。
     * @param ls 要归并的序列
     */
    public static void mergeSort(int[] ls){

    }
}
