package com.heatwave.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

public class _0235LowestCommonAncestorOfABinarySearchTree {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (p.val == root.val || q.val == root.val) {
                return root;
            }
            if ((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
                return root;
            }
            if (p.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    class AnotherSolution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            return root;
        }
    }

    class SolutionTwiceTraversal {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> pPath = getPath(root, p);
            List<TreeNode> qPath = getPath(root, q);

            int i = 0;
            while (i < pPath.size() && i < qPath.size()) {
                if (pPath.get(i) != qPath.get(i)) {
                    break;
                }
                i++;
            }

            return pPath.get(i - 1);
        }

        private List<TreeNode> getPath(TreeNode node, TreeNode p) {
            List<TreeNode> path = new LinkedList<>();
            while (true) {
                path.add(node);
                if (node == p) {
                    break;
                }
                if (p.val < node.val) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            return path;
        }
    }

    class SolutionOnceTraversal {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode ans = root;
            while (true) {
                if (p.val < ans.val && q.val < ans.val) {
                    ans = ans.left;
                } else if (p.val > ans.val && q.val > ans.val) {
                    ans = ans.right;
                } else {
                    break;
                }
            }
            return ans;
        }
    }
}
