package com.heatwave.leetcode.problems;

public class _0450DeleteNodeInABST {
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            TreeNode dummy = new TreeNode(-1);
            dummy.right = root;

            TreeNode node = root, prev = dummy;

            while (node != null) {
                if (node.val == key) {
                    if (node.left == null && node.right == null) {
                        if (node.val <= prev.val) {
                            prev.left = null;
                        } else {
                            prev.right = null;
                        }
                    } else if (node.left == null) {
                        if (node.val <= prev.val) {
                            prev.left = node.right;
                        } else {
                            prev.right = node.right;
                        }
                    } else if (node.right == null) {
                        if (node.val <= prev.val) {
                            prev.left = node.left;
                        } else {
                            prev.right = node.left;
                        }
                    } else {
                        TreeNode successor = node.right;
                        if (successor.left == null) {
                            successor.left = node.left;
                        } else {
                            TreeNode successorPrev = successor;
                            while (successor.left != null) {
                                successorPrev = successor;
                                successor = successor.left;
                            }
                            successorPrev.left = successor.right;
                            successor.left = node.left;
                            successor.right = node.right;
                        }

                        if (node.val <= prev.val) {
                            prev.left = successor;
                        } else {
                            prev.right = successor;
                        }
                    }
                    break;
                }
                prev = node;
                if (node.val >= key) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }

            return dummy.right;
        }
    }

    class SolutionRecursive {
        public TreeNode deleteNode(TreeNode root, int key) {
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
}
