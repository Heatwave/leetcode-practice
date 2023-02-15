package com.heatwave.leetcode.problems;

import java.util.Arrays;

public class _0136SingleNumber {
    class Solution {
        public int singleNumber(int[] nums) {
            Arrays.sort(nums);
            int count = 0, n = nums.length;
            for (int i = 1; i < n; i++) {
                if (nums[i - 1] == nums[i]) {
                    count++;
                } else {
                    if (count == 0) {
                        return nums[i - 1];
                    }
                    count = 0;
                }
            }
            return nums[n - 1];
        }
    }

    class SolutionXor {
        public int singleNumber(int[] nums) {
            int num = nums[0], n = nums.length;
            for (int i = 1; i < n; i++) {
                num = num ^ nums[i];
            }
            return num;
        }
    }
}
