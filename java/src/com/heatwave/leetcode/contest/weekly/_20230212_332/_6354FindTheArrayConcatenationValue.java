package com.heatwave.leetcode.contest.weekly._20230212_332;

public class _6354FindTheArrayConcatenationValue {
    class Solution {
        public long findTheArrayConcVal(int[] nums) {
            long ans = 0L;
            int n = nums.length;
            int i = 0, j = n - 1;
            while (i <= j) {
                if (i == j) {
                    ans += nums[i];
                } else {
                    ans += Long.parseLong("" + nums[i] + nums[j]);
                }
                i++;
                j--;
            }
            return ans;
        }
    }
}
