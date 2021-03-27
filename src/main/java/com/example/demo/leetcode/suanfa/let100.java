package com.example.demo.leetcode.suanfa;

/**
 * 描述：相同的树
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:04
 */
public class let100 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p==null && q==null){
                return true;
            }
            if(p==null || q==null){
                return false;
            }
            if(p.val != q.val){
                return false;
            }
            return isSameTree(p.left,q.left)&isSameTree(p.right,q.right);
        }
    }
}
