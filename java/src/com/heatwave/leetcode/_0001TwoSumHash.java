package com.heatwave.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

public class _0001TwoSumHash {
    static class Solution {

        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                hashMap.put(nums[i], i);
            }

            for (int i = 0; i < nums.length; i++) {
                int val = target - nums[i];
                Integer valIndex = hashMap.get(val);
                if (valIndex != null && valIndex != i) {
                    return new int[]{i, valIndex};
                }
            }
            throw new IllegalArgumentException("no answer");
        }
    }

    public static void main(String[] args) {
        _0001TwoSumHash.Solution solution = new _0001TwoSumHash.Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        int[] res = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
