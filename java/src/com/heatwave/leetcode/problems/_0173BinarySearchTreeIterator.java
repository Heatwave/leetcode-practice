package com.heatwave.leetcode.problems;

import java.util.*;

public class _0173BinarySearchTreeIterator {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
    class BSTIterator {
        List<Integer> list;
        Iterator<Integer> iterator;

        public BSTIterator(TreeNode root) {
            list = new LinkedList<>();
            inorder(root, list);
            iterator = list.iterator();
        }

        public int next() {
            return iterator.next();
        }

        public boolean hasNext() {
            return iterator.hasNext();
        }

        private void inorder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }

            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }

    class BSTIteratorAdvanced {
        Deque<TreeNode> deque = new ArrayDeque<>();

        public BSTIteratorAdvanced(TreeNode root) {
            dfs(root);
        }

        public int next() {
            TreeNode root = deque.pollLast();
            int next = root.val;
            root = root.right;
            dfs(root);
            return next;
        }

        public boolean hasNext() {
            return !deque.isEmpty();
        }

        private void dfs(TreeNode root) {
            while (root != null) {
                deque.addLast(root);
                root = root.left;
            }
        }
    }
}
