package com.heatwave.leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _0145BinaryTreePostorderTraversal {
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

    class Solution {
        List<Integer> ans = new ArrayList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return ans;
            }

            postorderTraversal(root.left);
            postorderTraversal(root.right);
            ans.add(root.val);

            return ans;
        }
    }

    class SolutionAddAll {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            res.addAll(postorderTraversal(root.left));
            res.addAll(postorderTraversal(root.right));
            res.add(root.val);

            return res;
        }
    }

    class SolutionIteration {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode prev = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.add(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.right == null || root.right == prev) {
                    ans.add(root.val);
                    prev = root;
                    root = null;
                } else {
                    stack.add(root);
                    root = root.right;
                }
            }
            return ans;
        }
    }

    class SolutionMorris {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            TreeNode temp = root, predecessor;

            while (temp != null) {
                predecessor = temp.left;
                if (predecessor == null) {
                    temp = temp.right;
                    continue;
                }

                while (predecessor.right != null && predecessor.right != temp) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = temp;
                    temp = temp.left;
                    continue;
                } else {
                    predecessor.right = null;
                    addPath(ans, temp.left);
                }
                temp = temp.right;
            }

            addPath(ans, root);
            return ans;
        }

        public void addPath(List<Integer> ans, TreeNode node) {
            int count = 0;
            while (node != null) {
                ++count;
                ans.add(node.val);
                node = node.right;
            }
            int left = ans.size() - count, right = ans.size() - 1;
            while (left < right) {
                int temp = ans.get(left);
                ans.set(left, ans.get(right));
                ans.set(right, temp);
                left++;
                right--;
            }
        }
    }
}
