package com.heatwave.leetcode.contest.biweekly._20230318_100;

import java.util.Arrays;

public class _6324MaximizeGreatnessOfAnArray {
    class Solution {
        public int maximizeGreatness(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int left = n - 1, right = n - 1;
            while (left >= 0 && right >= 0) {
                if (nums[left] < nums[right]) {
                    left--;
                    right--;
                } else {
                    left--;
                }
            }
            return n - 1 - right;
        }
    }
}
