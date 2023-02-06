package com.heatwave.leetcode.contest.weekly._20230205_331;

public class _2560HouseRobberIV {
    static class Solution {
        // From https://leetcode.cn/problems/house-robber-iv/solution/er-fen-da-an-dp-by-endlesscheng-m558/
        public int minCapability(int[] nums, int k) {
            int left = 0, right = getMaxFromArray(nums);
            while (left + 1 < right) {
                int mid = left + ((right - left) >>> 1);    // binary search
                int f0 = 0, f1 = 0; // DP
                for (int x : nums)
                    if (x > mid) f0 = f1;
                    else {
                        int tmp = f1;
                        f1 = Math.max(f1, f0 + 1);
                        f0 = tmp;
                    }
                if (f1 >= k) right = mid;
                else left = mid;
            }
            return right;
        }

        private int getMaxFromArray(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(num, max);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minCapability(new int[]{2, 3, 5, 9}, 2);
    }
}
