package com.heatwave.leetcode.problems;

public class _0027RemoveElement {
    static class Solution {
        public int removeElement(int[] nums, int val) {
            int n = nums.length;
            int left = 0, right = n - 1;
            while (left <= right) {
                while (left < n && nums[left] != val) {
                    left += 1;
                }
                while (right >= 0 && nums[right] == val) {
                    right -= 1;
                }
                if (left > right) {
                    break;
                }
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

            return left;
        }
    }

    static class SolutionSlowFast {
        public int removeElement(int[] nums, int val) {
            int n = nums.length;
            int slow = 0, fast = 0;
            while (fast < n) {
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }
    }
}
