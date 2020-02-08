package algorithm;

import java.util.*;

/**
 * create by yongli on 2020-02-02 00:04
 * 为什么这个算法在1ms就结束了
 */

class Permutation {

    public static void main(String[] args) {
        int[] a = {2,44,223,898};
        int[][] b =new int[4][4];
        //填充所有的元素.
        for(int i=0;i<a.length;++i){
            for(int j = i+1;j<a.length;++j){
                int  sum =0;
                // 这个是元素的定义
                for(int k = j;k<a.length;++k){
                    sum += a[k];
                }
                b[i][j] = sum;
            }
        }
        //System.out.println(b);数组输出有问题.
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }

        for(int i=0;i<b.length;i++){
            for(int j = 0;j<b[i].length;++j){
                System.out.print(b[i][j]);
                System.out.println("    ");
            }
            System.out.print("\n");
        }
    }

    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new LinkedList<List<Integer>>();

        dfs(0, nums);

        return res;

    }
    //树演变成了图

    /**
     * 这个方法中多次发生递归调用，理解起来有些困难
     * @param idx
     * @param nums
     */
    private void dfs(int idx, int[] nums){
        if(idx == nums.length - 1){
            List<Integer> list = new ArrayList<>();
            for(int i : nums){
                list.add(i);
            }

            res.add(list);
            return;
        }
        dfs(idx + 1, nums);

        Set<Integer> set = new HashSet<>();

        for(int i = idx + 1; i < nums.length; i++){
            // set.add方法的状态返回值用的非常好
            if(nums[idx] != nums[i] && set.add(nums[i])){
                swap(idx, i, nums);
                dfs(idx + 1, nums);
                swap(idx, i, nums);
            }
        }
    }

    private void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


}
