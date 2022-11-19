package com.heatwave.leetcode;

public class _0035SearchInsertPosition {
    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            while (left <= right) {
                int mid = (right - left) / 2 + left;
                int midVal = nums[mid];
                if (target == midVal) {
                    return mid;
                } else if (target < midVal) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return right + 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 6};
        int res = solution.searchInsert(nums, 7);
        System.out.println(res);
    }
}
