package com.heatwave.leetcode;

import java.util.Arrays;

public class _0977SquaresOfASortedArray {
    static class Solution {
        public int[] soartedSquares(int[] nums) {
            int[] res = new int[nums.length];
            int left = 0, right = nums.length - 1;

            int current = right;

            while (left <= right) {
                int leftVal = nums[left] < 0 ? -nums[left] : nums[left];
                int rightVal = nums[right] < 0 ? -nums[right] : nums[right];
                if (rightVal >= leftVal) {
                    res[current] = rightVal * rightVal;
                    right--;
                } else {
                    res[current] = leftVal * leftVal;
                    left++;
                }
                current--;
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-7, -3, 2, 3, 11};
//        int[] nums = {-3, -2, -1};
        int[] res = solution.soartedSquares(nums);
        System.out.println(Arrays.toString(res));
    }
}
