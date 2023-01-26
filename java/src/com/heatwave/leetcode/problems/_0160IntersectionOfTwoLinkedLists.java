package com.heatwave.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class _0160IntersectionOfTwoLinkedLists {
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
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> set = new HashSet<>();

            while (headA != null) {
                set.add(headA);
                headA = headA.next;
            }

            while (headB != null) {
                if (set.contains(headB)) {
                    return headB;
                }
                headB = headB.next;
            }

            return null;
        }
    }

    static class SolutionO1Memory {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode pa = headA, pb = headB;
            boolean aSwitch = false, bSwitch = false;
            while (pa != null && pb != null) {
                if (pa == pb) {
                    return pa;
                }
                pa = pa.next;
                pb = pb.next;
                if (!aSwitch && pa == null) {
                    pa = headB;
                    aSwitch = true;
                }
                if (!bSwitch && pb == null) {
                    pb = headA;
                    bSwitch = true;
                }
            }

            return null;
        }
    }
}
