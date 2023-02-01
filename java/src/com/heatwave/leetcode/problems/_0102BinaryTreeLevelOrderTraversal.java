package com.heatwave.leetcode.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0102BinaryTreeLevelOrderTraversal {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new LinkedList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new LinkedList<>();
                int n = queue.size();
                while (n-- > 0) {
                    TreeNode node = queue.remove();
                    level.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                ans.add(level);
            }
            return ans;
        }
    }
}
