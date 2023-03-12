package com.heatwave.leetcode.contest.weekly._20230312_336;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class _6316RearrangeArrayToMaximizePrefixScore {
    static class Solution {
        public int maxScore(int[] nums) {
            List<Integer> list = Arrays.stream(nums)
                    .boxed()
                    .sorted(Collections.reverseOrder())
                    .collect(Collectors.toList());
            List<Long> prefix = new LinkedList<>();
            prefix.add(Long.valueOf(list.get(0)));
            for (int i = 1; i < list.size(); i++) {
                prefix.add(prefix.get(i - 1) + list.get(i));
            }

            int ans = 0;
            for (Long l : prefix) {
                if (l > 0) {
                    ans += 1;
                } else {
                    break;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxScore(new int[]{2, -1, 0, 1, -3, 3, -3});
    }
}
