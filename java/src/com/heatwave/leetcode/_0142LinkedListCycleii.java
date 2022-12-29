package com.heatwave.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _0142LinkedListCycleii {
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
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head, fast = head;
            boolean hasCycle = false;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    hasCycle = true;
                    break;
                }
            }

            if (!hasCycle) {
                return null;
            }

            slow = head;

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }
    }

    static class SolutionHash {
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                if (set.contains(head)) {
                    break;
                }
                set.add(head);
                head = head.next;
            }

            return head;
        }
    }
}
