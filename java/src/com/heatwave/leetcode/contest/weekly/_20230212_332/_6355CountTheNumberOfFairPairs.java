package com.heatwave.leetcode.contest.weekly._20230212_332;

import java.util.Arrays;

public class _6355CountTheNumberOfFairPairs {
    static class Solution {
        public long countFairPairs(int[] nums, int lower, int upper) {
            long ans = 0L;
            Arrays.sort(nums);
            int n = nums.length, left = n - 1, right = n - 1;
            for (int i = 0; i < n - 1; i++) {
                int num = nums[i];
                left = Math.max(i, left);

                while (left > i && num + nums[left] >= lower) {
                    left--;
                }

                while (right > i && num + nums[right] > upper) {
                    right--;
                }

                if (right >= left) {
                    ans += right - left;
                } else {
                    break;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6);
    }
}
