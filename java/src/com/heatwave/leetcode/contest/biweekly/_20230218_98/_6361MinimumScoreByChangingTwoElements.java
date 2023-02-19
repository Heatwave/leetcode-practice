package com.heatwave.leetcode.contest.biweekly._20230218_98;

import java.util.Arrays;

public class _6361MinimumScoreByChangingTwoElements {
    class Solution {
        public int minimizeSum(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int i = nums[n - 3] - nums[0];
            int j = nums[n - 2] - nums[1];
            int k = nums[n - 1] - nums[2];
            return Math.min(Math.min(i, j), Math.min(j, k));
        }
    }
}
