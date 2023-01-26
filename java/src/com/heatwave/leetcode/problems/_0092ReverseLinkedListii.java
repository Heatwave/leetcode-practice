package com.heatwave.leetcode.problems;

/**
 * 92. Reverse Linked List II
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */

public class _0092ReverseLinkedListii {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {

        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m == n)
                return head;

            ListNode prev = null, next, p = head;
            ListNode left = null, right = null;
            int count = 1;

            while (p != null && count <= n) {
                next = p.next;

                if (count == m) {
                    left = prev;
                    right = p;
                }

                if (count >= m)
                    p.next = prev;

                if (count == n) {
                    if (left != null)
                        left.next = p;
                    assert right != null;
                    right.next = next;

                    if (m == 1)
                        head = p;
                }

                prev = p;
                p = next;
                count++;
            }
            return head;
        }
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        listNode = solution.reverseBetween(listNode, 2, 4);

        ListNode p = listNode;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
