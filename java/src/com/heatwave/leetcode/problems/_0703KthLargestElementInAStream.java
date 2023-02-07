package com.heatwave.leetcode.problems;

import java.util.PriorityQueue;

public class _0703KthLargestElementInAStream {
    static class KthLargest {
        int k;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            pq.add(val);
            if (pq.size() > k) {
                pq.remove();
            }
            return pq.element();
        }
    }

    static class KthLargestBST {
        int k;
        TreeNode root;

        public KthLargestBST(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                root = insertIntoBSTWithCnt(root, num);
            }
        }

        public int add(int val) {
            root = insertIntoBSTWithCnt(root, val);
            return findKth(root, k);
        }

        private static class TreeNodeWithCnt extends TreeNode {
            int cnt;

            TreeNodeWithCnt(int val, int cnt) {
                this.val = val;
                this.cnt = cnt;
            }
        }

        private TreeNode insertIntoBSTWithCnt(TreeNode root, int val) {
            if (root == null) {
                return new TreeNodeWithCnt(val, 1);
            }
            ((TreeNodeWithCnt) root).cnt++;
            if (root.val >= val) {
                root.left = insertIntoBSTWithCnt(root.left, val);
                return root;
            }
            root.right = insertIntoBSTWithCnt(root.right, val);
            return root;
        }

        private int findKth(TreeNode root, int k) {
            int currentK;
            if (root.right == null) {
                currentK = 1;
            } else {
                currentK = ((TreeNodeWithCnt) root.right).cnt + 1;
            }

            if (k == currentK) {
                return root.val;
            } else if (k > currentK) {
                return findKth(root.left, k - currentK);
            } else {
                return findKth(root.right, k);
            }
        }
    }
}
