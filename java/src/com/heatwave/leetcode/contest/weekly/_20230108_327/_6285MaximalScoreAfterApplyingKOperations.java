package com.heatwave.leetcode.contest.weekly._20230108_327;

import java.util.PriorityQueue;

public class _6285MaximalScoreAfterApplyingKOperations {
    static class Solution {
        public long maxKelements(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
            for (int num : nums) {
                pq.add(num);
            }

            long ans = 0;
            while (k > 0) {
                Integer max = pq.poll();
                ans += max;
                max = (max + 2) / 3;
                pq.add(max);
                k--;
            }
            return ans;
        }
    }
}
