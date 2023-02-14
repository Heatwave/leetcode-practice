package com.heatwave.leetcode.problems;

public class _0108ConvertSortedArrayToBinarySearchTree {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            int n = nums.length;
            return helper(nums, 0, n - 1);
        }

        private TreeNode helper(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            int middle = (left + right) / 2;
            TreeNode root = new TreeNode(nums[middle]);
            root.left = helper(nums, left, middle - 1);
            root.right = helper(nums, middle + 1, right);
            return root;
        }
    }
}
