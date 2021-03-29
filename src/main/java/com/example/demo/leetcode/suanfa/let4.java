package com.example.demo.leetcode.suanfa;

import java.util.Arrays;
import java.util.List;

/**
 * 描述：寻找两个正序数组的中位数
 *
 * @author yinjiaqi
 * @date 2021/3/29 11:15
 */
public class let4 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] sort = sort(nums1, nums2);
            int length = sort.length;
            if (length == 0) return 0;
            if (length == 1) return sort[0];
            if (length % 2 == 0) {
                int i = length / 2;
                return ((double) (sort[i-1] + sort[i]) / 2);
            } else {
                int i = length / 2;
                return sort[i];
            }
        }

        public int[] sort(int[] a, int[] b) {
            int i = 0;
            int j = 0;
            int k = 0;
            int[] c = new int[a.length + b.length];
            while (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    c[k++] = a[i++];
                } else {
                    c[k++] = b[j++];
                }
            }
            while (i < a.length) {
                c[k++] = a[i++];
            }
            while (j < b.length) {
                c[k++] = b[j++];
            }
            return c;
        }
    }
}
