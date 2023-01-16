package com.heatwave.leetcode.contest.weekly._20230115_328;

public class _6292IncrementSubMatricesByOne {
    static class Solution {
        public int[][] rangeAddQueries(int n, int[][] queries) {
            int[][] mat = new int[n][n];

            for (int[] query : queries) {
                int row1 = query[0];
                int col1 = query[1];
                int row2 = query[2];
                int col2 = query[3];
                for (int i = row1; i <= row2; i++) {
                    for (int j = col1; j <= col2; j++) {
                        int elem = mat[i][j];
                        elem += 1;
                        mat[i][j] = elem;
                    }
                }
            }
            return mat;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] queries = new int[2][4];
        int[] query1 = new int[]{1, 1, 2, 2};
        int[] query2 = new int[]{0, 0, 1, 1};
        queries[0] = query1;
        queries[1] = query2;
        solution.rangeAddQueries(3, queries);
    }
}
