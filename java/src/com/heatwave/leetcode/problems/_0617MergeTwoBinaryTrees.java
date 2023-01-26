package com.heatwave.leetcode.problems;

/**
 * You are given two binary trees root1 and root2.
 * <p>
 * Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
 * <p>
 * Return the merged tree.
 * <p>
 * Note: The merging process must start from the root nodes of both trees.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * Output: [3,4,5,5,4,null,7]
 * Example 2:
 * <p>
 * Input: root1 = [1], root2 = [1,2]
 * Output: [2,2]
 *  
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both trees is in the range [0, 2000].
 * -104 <= Node.val <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0617MergeTwoBinaryTrees {
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

    static class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return null;
            } else if (root1 == null) {
                return root2;
            } else if (root2 == null) {
                return root1;
            }
            root1.val += root2.val;

            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
    }
}
