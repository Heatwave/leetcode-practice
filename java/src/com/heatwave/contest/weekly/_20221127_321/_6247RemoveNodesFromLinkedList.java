package com.heatwave.contest.weekly._20221127_321;

public class _6247RemoveNodesFromLinkedList {
    public class ListNode {
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
        public ListNode removeNodes(ListNode head) {
            if (head.next == null) {
                return head;
            }

            return remove(head, head.next);
        }

        private ListNode remove(ListNode left, ListNode right) {
            if (right == null) {
                return left;
            }

            ListNode rightNode = remove(right, right.next);

            if (rightNode.val > left.val) {
                return rightNode;
            } else {
                left.next = rightNode;
                return left;
            }
        }
    }
}
