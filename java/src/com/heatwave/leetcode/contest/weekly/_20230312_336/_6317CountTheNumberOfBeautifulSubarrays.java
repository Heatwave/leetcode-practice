package com.heatwave.leetcode.contest.weekly._20230312_336;

import java.util.HashMap;
import java.util.Map;

public class _6317CountTheNumberOfBeautifulSubarrays {
    static class Solution {
        public long beautifulSubarrays(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();

            int n = nums.length;
            int[] prefixXor = new int[n + 1];
            prefixXor[0] = 0;
            for (int i = 1; i < n + 1; i++) {
                prefixXor[i] = prefixXor[i - 1] ^ nums[i - 1];
            }

            long ans = 0;
            int cnt;
            for (int i : prefixXor) {
                cnt = map.getOrDefault(i, 0);
                ans += cnt;
                map.put(i, cnt + 1);
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.beautifulSubarrays(new int[]{4, 3, 1, 2, 4});
    }
}
