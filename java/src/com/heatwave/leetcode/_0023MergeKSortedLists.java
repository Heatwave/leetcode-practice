package com.heatwave.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _0023MergeKSortedLists {
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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            if (lists.length == 1) {
                return lists[0];
            }

            ListNode ans = null;
            for (ListNode list : lists) {
                ans = mergeTwoLists(ans, list);
            }

            return ans;
        }

        /**
         * @see _0021MergeTwoSortedLists.SolutionRecursive
         */
        private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null) {
                return null;
            } else if (list1 == null) {
                return list2;
            } else if (list2 == null) {
                return list1;
            }

            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
    }

    static class SolutionPriorityQueue {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            if (lists.length == 1) {
                return lists[0];
            }

            PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                    lists.length, Comparator.comparingInt(l -> l.val)
            );

            for (ListNode list : lists) {
                if (list != null) {
                    priorityQueue.add(list);
                }
            }

            ListNode ans = new ListNode();
            ListNode p = ans;

            ListNode node = priorityQueue.poll();
            while (node != null) {
                p.next = node;
                p = node;
                if (node.next != null) {
                    priorityQueue.add(node.next);
                }
                node = priorityQueue.poll();
            }

            return ans.next;
        }
    }

    public static void main(String[] args) {
        SolutionPriorityQueue solution = new SolutionPriorityQueue();
        ListNode list1 = new ListNode(5);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(8);
        ListNode[] listNodes = {list1, list2, list3};
        solution.mergeKLists(listNodes);
    }
}
