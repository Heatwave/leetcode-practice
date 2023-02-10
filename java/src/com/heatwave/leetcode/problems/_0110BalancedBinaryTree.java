package com.heatwave.leetcode.problems;

public class _0110BalancedBinaryTree {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (Math.abs(getTreeHeight(root.left) - getTreeHeight(root.right)) > 1) {
                return false;
            }
            return isBalanced(root.left) && isBalanced(root.right);
        }

        private int getTreeHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
        }
    }
}
