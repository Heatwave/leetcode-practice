package com.heatwave.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

public class _0104MaximumDepthOfBinaryTree {
    static class Solution {
        public int maxDepth(TreeNode root) {
            return findDepth(root, 0);
        }

        private int findDepth(TreeNode root, int depth) {
            if (root == null) {
                return depth;
            }
            return Math.max(findDepth(root.left, depth + 1), findDepth(root.right, depth + 1));
        }
    }

    static class SolutionDFS {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    static class SolutionBFS {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int ans = 0;
            while (!queue.isEmpty()) {
                int n = queue.size();
                while (n-- > 0) {
                    TreeNode node = queue.remove();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                ans++;
            }
            return ans;
        }
    }

    static class SolutionBacktrack {
        int ans = 0;
        int depth = 0;

        public int maxDepth(TreeNode root) {
            traverse(root);
            return ans;
        }

        public void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            // preorder
            depth++;
            if (root.left == null && root.right == null) {
                ans = Math.max(ans, depth);
            }
            traverse(root.left);
            traverse(root.right);
            // postorder
            depth--;
        }
    }
}
