package com.heatwave.template.algorithms;

public class BinarySearch {
    public static int search(int[] nums, int target) {
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
