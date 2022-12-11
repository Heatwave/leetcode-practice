package com.heatwave.leetcode.contest.weekly._20221204_322;

import java.util.Arrays;

public class _6254DividePlayersIntoTeamsOfEqualSkill {
    static class Solution {
        public long dividePlayers(int[] skill) {
            Arrays.sort(skill);

            int count = skill.length;
            long[] team = new long[count];
            int teamCount = 0;

            long same = skill[0] + skill[count - 1];

            int first = 0, last = count - 1;
            while (first < last) {
                long left = skill[first], right = skill[last];
                if (left + right != same) {
                    return -1;
                }
                team[teamCount++] = left;
                team[teamCount++] = right;
                first++;
                last--;
            }

            long res = 0;
            for (int i = 0; i < teamCount; i += 2) {
                res += team[i] * team[i + 1];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] sk = new int[]{3, 2, 5, 1, 3, 4};
        Solution solution = new Solution();
        solution.dividePlayers(sk);
    }
}
