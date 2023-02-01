package com.heatwave.leetcode.problems;

public class _0701InsertIntoABinarySearchTree {
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (root.val >= val) {
                root.left = insertIntoBST(root.left, val);
                return root;
            }
            root.right = insertIntoBST(root.right, val);
            return root;
        }
    }

    class SolutionIteration {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }

            TreeNode node = root;
            while (true) {
                if (node.val >= val) {
                    if (node.left == null) {
                        node.left = new TreeNode(val);
                        break;
                    }
                    node = node.left;
                } else {
                    if (node.right == null) {
                        node.right = new TreeNode(val);
                        break;
                    }
                    node = node.right;
                }
            }

            return root;
        }
    }
}
