package com.heatwave.leetcode.problems;

public class _0700SearchInABinarySearchTree {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            }
            if (root.val == val) {
                return root;
            }

            if (root.val >= val) {
                return searchBST(root.left, val);
            }
            return searchBST(root.right, val);
        }
    }

    class SolutionIteration {
        public TreeNode searchBST(TreeNode root, int val) {
            while (root != null) {
                if (root.val == val) {
                    return root;
                }
                if (root.val >= val) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }

            return null;
        }
    }
}
