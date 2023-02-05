package com.heatwave.leetcode.contest.biweekly._20230204_97;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _6303SeparateTheDigitsInAnArray {
    class Solution {
        public int[] separateDigits(int[] nums) {
            List<Integer> ans = new LinkedList<>();
            for (int num : nums) {
                Arrays.stream(String.valueOf(num).split("")).forEach(s -> ans.add(Integer.parseInt(s)));
            }
            int[] arr = new int[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                arr[i] = ans.get(i);
            }
            return arr;
        }
    }
}
