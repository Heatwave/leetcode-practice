package com.heatwave.leetcode.problems;

public class _0220ContainsDuplicateiii {
    static class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            TreeNode root = null;
            int nodeCount = 0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (searchInBST(root, num - valueDiff, num + valueDiff)) {
                    return true;
                }
                root = insertIntoBST(root, num);
                nodeCount++;
                if (nodeCount > indexDiff) {
                    root = deleteNode(root, nums[i - indexDiff]);
                }
            }
            return false;
        }

        private boolean searchInBST(TreeNode root, int low, int high) {
            if (root == null) {
                return false;
            }
            if (root.val < low) {
                return searchInBST(root.right, low, high);
            }
            if (root.val > high) {
                return searchInBST(root.left, low, high);
            }
            return true;
        }

        private TreeNode insertIntoBST(TreeNode root, int val) {
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

        private TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
                return root;
            }
            if (root.val < key) {
                root.right = deleteNode(root.right, key);
                return root;
            }
            if (root.val == key) {
                if (root.left == null && root.right == null) {
                    return null;
                }
                if (root.left == null) {
                    return root.right;
                }
                if (root.right == null) {
                    return root.left;
                }
                TreeNode successor = root.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                root.right = deleteNode(root.right, successor.val);
                successor.right = root.right;
                successor.left = root.left;
                return successor;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3);
    }
}
