package com.heatwave.leetcode;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 *  
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/middle-of-the-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0876MiddleOfTheLinkedList {
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
        public ListNode middleNode(ListNode head) {
            ListNode node = head;
            int count = 0;

            while (node != null) {
                node = node.next;
                count++;
            }

            count = count / 2;

            node = head;
            while (count > 0) {
                node = node.next;
                count--;
            }

            return node;
        }
    }

    static class SolutionDoublePoint {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head;

            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            if (fast.next != null) {
                slow = slow.next;
            }

            return slow;
        }
    }
}
