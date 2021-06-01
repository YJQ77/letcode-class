package com.example.demo.leetcode.suanfa;

/**
 * 描述：剑指 Offer 11. 旋转数组的最小数字
 *
 * @author yinjiaqi
 * @date 2021/5/6 13:55
 */
public class let剑指Offer11 {
    public int minArray(int[] numbers) {
           if (numbers==null || numbers.length==0){
               return -1;
           }
           if (numbers.length==1){
               return numbers[0];
           }
           int result = numbers[0];
           for (int i : numbers){
               result = result>i?i:result;
           }
           return result;
    }
    public int minArray2(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

}
