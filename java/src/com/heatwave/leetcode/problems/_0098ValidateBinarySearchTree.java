package com.heatwave.leetcode.problems;

public class _0098ValidateBinarySearchTree {
    class Solution {
        long num = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            boolean leftIsValid = isValidBST(root.left);
            if (root.val <= num) {
                return false;
            }
            num = root.val;
            boolean rightIsValid = isValidBST(root.right);
            return leftIsValid && rightIsValid;
        }
    }

    class AnotherSolution {
        public boolean isValidBST(TreeNode root) {
            return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean helper(TreeNode root, long lower, long upper) {
            if (root == null) {
                return true;
            }
            if (root.val <= lower || root.val >= upper) {
                return false;
            }
            return helper(root.left, lower, root.val) && helper(root.right, root.val, upper);
        }
    }
}
