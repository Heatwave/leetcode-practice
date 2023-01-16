package com.heatwave.leetcode.contest.weekly._20230115_328;

public class _6291DifferenceBetweenElementSumAndDigitSumOfAnArray {
    static class Solution {
        public int differenceOfSum(int[] nums) {
            int elementSum = 0, digitSum = 0;
            for (int num : nums) {
                elementSum += num;
                String s = String.valueOf(num);
                for (String digit : s.split("")) {
                    digitSum += Integer.parseInt(digit);
                }
            }

            return Math.abs(elementSum - digitSum);
        }
    }

    static class SolutionWithoutString {
        public int differenceOfSum(int[] nums) {
            int elementSum = 0, digitSum = 0;
            for (int num : nums) {
                elementSum += num;
                while (num != 0) {
                    digitSum += num % 10;
                    num /= 10;
                }
            }
            return Math.abs(elementSum - digitSum);
        }
    }

    static class SolutionOptimized {
        public int differenceOfSum(int[] nums) {
            int s = 0;
            for (int num : nums) {
                s += num;
                while (num != 0) {
                    s -= num % 10;
                    num /= 10;
                }
            }
            return s;
        }
    }
}
