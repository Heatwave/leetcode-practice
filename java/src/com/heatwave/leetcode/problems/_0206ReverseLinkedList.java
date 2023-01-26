package com.heatwave.leetcode.problems;

/**
 * 206. Reverse Linked List
 * <p>
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class _0206ReverseLinkedList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode left = null, middle = head, right = head.next;

            while (right != null) {
                middle.next = left;
                left = middle;
                middle = right;
                right = right.next;
            }

            middle.next = left;

            return middle;
        }
    }

    static class SolutionRecursive {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;

            return newHead;
        }
    }
}
