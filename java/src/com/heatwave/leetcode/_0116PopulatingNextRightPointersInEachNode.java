package com.heatwave.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * Example 2:
 * <p>
 * Input: root = []
 * Output: []
 *  
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 212 - 1].
 * -1000 <= Node.val <= 1000
 *  
 * <p>
 * Follow-up:
 * <p>
 * You may only use constant extra space.
 * The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0116PopulatingNextRightPointersInEachNode {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    static class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Deque<Node> deque = new ArrayDeque<>();
            deque.addLast(root);

            while (!deque.isEmpty()) {
                int size = deque.size();
                Node node = null;
                for (int i = 0; i < size; i++) {
                    node = deque.removeFirst();
                    node.next = deque.peekFirst();
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                }
                node.next = null;
            }

            return root;
        }
    }

    static class SolutionRecursive {
        public Node connect(Node root) {
            if (root == null || root.left == null) {
                return root;
            }

            root.left.next = root.right;

            if (root.next != null) {
                root.right.next = root.next.left;
            }

            connect(root.left);
            connect(root.right);
            return root;
        }
    }
}
