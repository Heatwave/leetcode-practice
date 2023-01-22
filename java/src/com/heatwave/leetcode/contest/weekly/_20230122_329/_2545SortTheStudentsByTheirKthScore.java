package com.heatwave.leetcode.contest.weekly._20230122_329;

import java.util.ArrayList;
import java.util.List;

public class _2545SortTheStudentsByTheirKthScore {
    static class Solution {
        public int[][] sortTheStudents(int[][] score, int k) {
            int m = score.length, n = score[0].length;
            List<Pair<Integer, Integer>> list = new ArrayList<>();
            for (int i = 0; i < score.length; i++) {
                int[] student = score[i];
                list.add(new Pair<>(i, student[k]));
            }
            list.sort((o1, o2) -> o2.second - o1.second);
            int[][] ans = new int[m][n];
            int index = 0;
            for (Pair<Integer, Integer> pair : list) {
                int[] student = score[pair.first];
                ans[index++] = student;
            }
            return ans;
        }

        static class Pair<T, U> {

            public Pair(T first, U second) {
                this.second = second;
                this.first = first;
            }

            public final T first;
            public final U second;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] score = new int[][]{
                {10, 6, 9, 1},
                {7, 5, 11, 2},
                {4, 8, 3, 15}
        };
        solution.sortTheStudents(score, 2);
    }
}
