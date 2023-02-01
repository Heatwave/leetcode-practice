package com.heatwave.leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _0144BinaryTreePreorderTraversal {
    class Solution {
        List<Integer> ans = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return ans;
            }

            ans.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);

            return ans;
        }
    }

    class SolutionAddAll {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            res.add(root.val);
            res.addAll(preorderTraversal(root.left));
            res.addAll(preorderTraversal(root.right));

            return res;
        }
    }

    class SolutionIteration {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    ans.add(root.val);
                    stack.add(root);
                    root = root.left;
                }
                root = stack.pop();
                root = root.right;
            }
            return ans;
        }
    }

    class SolutionMorris {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            TreeNode predecessor;

            while (root != null) {
                if (root.left == null) {
                    ans.add(root.val);
                    root = root.right;
                    continue;
                }

                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    ans.add(root.val);
                    predecessor.right = root;
                    root = root.left;
                    continue;
                } else {
                    predecessor.right = null;
                }
                root = root.right;
            }

            return ans;
        }
    }
}
