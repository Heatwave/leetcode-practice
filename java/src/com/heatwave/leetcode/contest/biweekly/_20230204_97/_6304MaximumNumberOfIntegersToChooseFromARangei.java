package com.heatwave.leetcode.contest.biweekly._20230204_97;

import java.util.HashSet;
import java.util.Set;

public class _6304MaximumNumberOfIntegersToChooseFromARangei {
    class Solution {
        public int maxCount(int[] banned, int n, int maxSum) {
            Set<Integer> set = new HashSet<>();
            for (int i : banned) {
                set.add(i);
            }

            int ans = 0, sum = 0;
            for (int i = 1; i <= n; i++) {
                if (sum + i > maxSum) {
                    break;
                }
                if (!set.contains(i)) {
                    ans++;
                    sum += i;
                }
            }
            return ans;
        }
    }
}
