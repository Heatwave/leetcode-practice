package com.heatwave.leetcode;

/*
  94. Binary Tree Inorder Traversal
  Given a binary tree, return the inorder traversal of its nodes' values.

  Example:

  Input: [1,null,2,3]
     1
      \
       2
      /
     3

  Output: [1,3,2]
  Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _0094BinaryTreeInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            res.addAll(inorderTraversal(root.left));
            res.add(root.val);
            res.addAll(inorderTraversal(root.right));
            return res;
        }
    }

    static class AnotherSolution {
        List<Integer> ans = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return ans;
            }

            inorderTraversal(root.left);
            ans.add(root.val);
            inorderTraversal(root.right);

            return ans;
        }
    }

    static class SolutionIteration {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.add(root);
                    root = root.left;
                }
                root = stack.pop();
                ans.add(root.val);
                root = root.right;
            }
            return ans;
        }
    }

    static class SolutionMorris {
        public List<Integer> inorderTraversal(TreeNode root) {
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
                    predecessor.right = root;
                    root = root.left;
                } else {
                    ans.add(root.val);
                    root = root.right;
                }
            }

            return ans;
        }
    }
}
