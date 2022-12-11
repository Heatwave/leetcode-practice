package com.heatwave.contest.weekly._20221211_323;

import java.util.Arrays;

public class _6258LongestSquareStreakInAnArray {
    static class Solution {
        public int longestSquareStreak(int[] nums) {
            int n = nums.length, count = 0, ans = 0;
            int[] sortedNums = Arrays.stream(nums).sorted().toArray();

            for (int i = 0; i < n; i++) {
                count++;
                int first = sortedNums[i];
                int res = first * first;
                do {
                    if (res > sortedNums[n - 1]) {
                        break;
                    }
                    int index = search(sortedNums, res);
                    if (index == -1) {
                        break;
                    } else {
                        int num = sortedNums[index];
                        res = num * num;
                        count++;
                    }
                } while (true);
                ans = Math.max(ans, count);
                count = 0;
            }

            return ans == 1 ? -1 : ans;
        }

        private int search(int[] nums, int target) {
            if (nums.length <= 0) {
                return -1;
            }

            int left = 0, right = nums.length - 1;

            int mid = (left + right) / 2;
            while (true) {
                int num = nums[mid];

                if (num > target) {
                    right = mid;
                } else if (num < target) {
                    left = mid;
                } else {
                    return mid;
                }

                if (nums[left] == target) {
                    return left;
                }
                if (nums[right] == target) {
                    return right;
                }

                mid = (left + right) / 2;

                if ((mid == left && nums[left] != target) || (mid == right && nums[right] != target)) {
                    return -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {2, 3, 5, 6, 7};
//        int[] nums = {4, 3, 6, 16, 8, 2};
//        int[] nums = {16, 4, 2};
        int[] nums = {2, 4, 3, 5};
        int ans = solution.longestSquareStreak(nums);
        System.out.println(ans);
    }
}
