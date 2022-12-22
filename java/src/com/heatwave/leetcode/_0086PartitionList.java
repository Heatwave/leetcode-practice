package com.heatwave.leetcode;

public class _0086PartitionList {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode current = dummy;

            while (current.next != null && current.next.val < x) {
                current = current.next;
            }

            ListNode left = current, right = current.next;

            while (right != null) {
                if (right.val < x) {
                    left.next = right.next;
                    right.next = current.next;
                    current.next = right;

                    current = right;

                    right = left.next;
                    continue;
                }

                left = left.next;
                right = right.next;
            }

            return dummy.next;
        }
    }

    static class AnotherSolution {
        public ListNode partition(ListNode head, int x) {
            ListNode less = null, lessHead = head, gte = null, gteHead = null;

            while (head != null) {
                if (head.val < x) {
                    if (less == null) {
                        less = head;
                        lessHead = head;
                    } else {
                        less.next = head;
                        less = head;
                    }
                } else {
                    if (gte == null) {
                        gte = head;
                        gteHead = head;
                    } else {
                        gte.next = head;
                        gte = head;
                    }
                }
                head = head.next;
            }

            if (less != null) {
                less.next = gteHead;
            }
            if (gte != null) {
                gte.next = null;
            }

            return lessHead;
        }
    }
}
