package com.heatwave.leetcode.contest.weekly._20230226_334;

public class _6369LeftAndRightSumDifferences {
    class Solution {
        public int[] leftRigthDifference(int[] nums) {
            int n = nums.length;
            int[] answer = new int[n];
            int[] leftSum = new int[n];
            int[] rightSum = new int[n];

            leftSum[0] = 0;
            for (int i = 1; i < n; i++) {
                leftSum[i] = leftSum[i - 1] + nums[i - 1];
            }

            rightSum[n - 1] = 0;
            for (int i = n - 2; i >= 0; i--) {
                rightSum[i] = rightSum[i + 1] + nums[i + 1];
            }

            for (int i = 0; i < n; i++) {
                answer[i] = Math.abs(leftSum[i] - rightSum[i]);
            }

            return answer;
        }
    }
}
