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
import java.util.Arrays;
import java.util.List;

public class _0094BinaryTreeInorderTraversalRecursion {

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

            List<Integer> tmp;
            tmp = inorderTraversal(root.left);
            res.addAll(tmp);
            res.add(root.val);
            tmp = inorderTraversal(root.right);
            res.addAll(tmp);

            return res;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        List<Integer> res = solution.inorderTraversal(root);
        List<Integer> answer = new ArrayList<>(Arrays.asList(4, 2, 5, 1, 6, 3, 7));
        assert res.equals(answer);
    }
}
