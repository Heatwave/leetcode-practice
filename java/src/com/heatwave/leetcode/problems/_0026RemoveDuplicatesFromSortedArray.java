package com.heatwave.leetcode.problems;

public class _0026RemoveDuplicatesFromSortedArray {
    static class Solution {
        public int removeDuplicates(int[] nums) {
            int pos = 0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                nums[pos] = num;
                pos++;
                while (i < nums.length && nums[i] == num) {
                    i++;
                }
                i--;
            }
            return pos;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeDuplicates(new int[]{1, 1, 2});
    }
}
