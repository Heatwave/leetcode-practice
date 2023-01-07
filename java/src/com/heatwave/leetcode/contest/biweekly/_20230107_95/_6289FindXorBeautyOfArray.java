package com.heatwave.leetcode.contest.biweekly._20230107_95;

import java.util.Arrays;

public class _6289FindXorBeautyOfArray {
    static class Solution {
        public int xorBeauty(int[] nums) {
            return Arrays.stream(nums).reduce((left, right) -> left ^ right).getAsInt();
        }
    }
}
