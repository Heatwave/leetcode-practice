package com.heatwave.leetcode.contest.weekly._20230226_334;

import java.util.Arrays;

public class _2576FindTheMaximumNumberOfMarkedIndices {
    static class Solution {
        public int maxNumOfMarkedIndices(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int ans = n % 2 == 0 ? n : n - 1;

            while (ans > 0) {
                boolean pass = true;
                int index = ans / 2;
                for (int i = 0; i < index; i++) {
                    if (nums[i] * 2 > nums[n - index + i]) {
                        ans -= 2;
                        pass = false;
                        break;
                    }
                }
                if (pass) {
                    break;
                }
            }

            return ans;
        }
    }

    static class SolutionBinarySearch {
        public int maxNumOfMarkedIndices(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            int left = 0, right = n / 2 + 1;

            while (left + 1 < right) {
                int mid = (left + right) / 2;
                if (check(nums, mid)) {
                    left = mid;
                } else {
                    right = mid;
                }
            }

            return left * 2;
        }

        private boolean check(int[] nums, int mid) {
            int n = nums.length;
            for (int i = 0; i < mid; i++) {
                if (nums[i] * 2 > nums[n - mid + i]) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 6, 8};
        Solution solution = new Solution();
        int ans = solution.maxNumOfMarkedIndices(nums);
        System.out.println("ans: " + ans);
    }
}
