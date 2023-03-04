package com.heatwave.leetcode.contest.biweekly._20230304_99;

import java.util.Arrays;

public class _6312SplitWithMinimumSum {
    class Solution {
        public int splitNum(int num) {
            String s = String.valueOf(num);
            int n = s.length();
            int[] nums = new int[n];
            int temp = num;
            for (int i = 0; i < n; i++) {
                nums[i] = temp % 10;
                temp /= 10;
            }
            Arrays.sort(nums);
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    s1.append(nums[i]);
                } else {
                    s2.append(nums[i]);
                }
            }

            return Integer.parseInt(s1.toString()) + Integer.parseInt(s2.toString());
        }
    }
}
