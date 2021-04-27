package com.example.demo.leetcode.suanfa;

/**
 * 描述：剑指 Offer 04. 二维数组中的查找
 *
 * @author yinjiaqi
 * @date 2021/4/26 14:44
 */
public class let剑指Offer4 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length==0){
            return false;
        }
        int n = matrix.length;//总行数
        int m = matrix[0].length;//总列数
        int row = 0;
        int clo = m - 1;
        while (row < n && clo >= 0) {
            if (target < matrix[row][clo]) {
                clo--;
            } else if (target > matrix[row][clo]) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}