package com.example.demo.leetcode.suanfa;

/**
 * 描述：K 次取反后最大化的数组和
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:05
 */
public class let1005 {
    class Solution {
        public  int largestSumAfterKNegations(int[] A, int K) {
            int[] sort = sort(A);
            for (int i = 0;i<sort.length;i++){
                if (sort[i]<0 && K>0){
                    sort[i] = sort[i]*-1;
                    K--;
                }
            }
            while (K>0)
            {
                sort[sort.length-1]  =sort[sort.length-1] * -1;
                K--;
            }
            int result = 0;
            for (int a : sort){
                result = result+a;
            }
            return result;
        }

        public  int[] sort(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (Math.abs(arr[j]) < Math.abs(arr[j + 1])) {
                        int tmp = arr[j + 1];//交换相邻两个元素
                        arr[j + 1] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }
            return arr;
        }
    }
}
