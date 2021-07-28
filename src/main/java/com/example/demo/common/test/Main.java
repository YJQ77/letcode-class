package com.example.demo.common.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.util.CollectionUtils;

/**
 * 描述：
 *
 * @author yinjiaqi
 * @date 2021/7/14 19:47
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length<=2) return Collections.emptyList();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0;i<n;i++){
            if (i>0 && nums[i]==nums[i-1]) continue;
            int L = i+1;
            int R = n-1;
            while (L<R){
                int temp = nums[i]+nums[L]+nums[R];
                if (temp==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    result.add(list);
                    while (L<R && nums[L]==nums[L+1] ) L++;
                    while (L<R && nums[R] == nums[R-1]) R--;
                    L++;R--;
                }
                if (temp>0){
                    R--;
                }
                if (temp<0){
                    L++;
                }
            }
        }
        return result;
    }
}

