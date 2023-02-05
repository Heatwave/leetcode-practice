package com.heatwave.leetcode.contest.weekly._20230205_331;

import java.util.PriorityQueue;

public class _6348TakeGiftsFromTheRichestPile {
    static class Solution {
        public long pickGifts(int[] gifts, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
            for (int gift : gifts) {
                pq.add(gift);
            }
            while (k-- > 0) {
                Integer gift = pq.poll();
                System.out.println(gift);
                if (gift == 1) {
                    return gifts.length;
                }
                double sqrt = Math.sqrt(gift);
                pq.add((int) sqrt);
            }
            long ans = 0;
            while (!pq.isEmpty()) {
                ans += pq.poll();
            }
            return ans;
        }
    }
}
