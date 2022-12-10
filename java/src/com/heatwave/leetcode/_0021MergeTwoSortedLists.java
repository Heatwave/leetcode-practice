package com.heatwave.leetcode;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * <p>
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 * <p>
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *  
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0021MergeTwoSortedLists {
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null) {
                return null;
            } else if (list1 == null) {
                return list2;
            } else if (list2 == null) {
                return list1;
            }

            ListNode listNode = new ListNode();

            if (list1.val < list2.val) {
                listNode.val = list1.val;
                list1 = list1.next;
            } else {
                listNode.val = list2.val;
                list2 = list2.next;
            }

            ListNode node = listNode;
            while (list1 != null || list2 != null) {
                if (list1 == null) {
                    node.next = list2;
                    break;
                }
                if (list2 == null) {
                    node.next = list1;
                    break;
                }
                if (list1.val < list2.val) {
                    node.next = new ListNode(list1.val);
                    node = node.next;
                    list1 = list1.next;
                } else {
                    node.next = new ListNode(list2.val);
                    node = node.next;
                    list2 = list2.next;
                }
            }

            return listNode;
        }
    }

    static class SolutionRecursive {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
}
