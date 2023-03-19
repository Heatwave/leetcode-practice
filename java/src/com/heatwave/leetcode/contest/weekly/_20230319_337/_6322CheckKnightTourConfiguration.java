package com.heatwave.leetcode.contest.weekly._20230319_337;

public class _6322CheckKnightTourConfiguration {
    class Solution {
        public boolean checkValidGrid(int[][] grid) {
            int n = grid.length;
            int max = n * n - 1;
            int step = 0;
            int row = 0, col = 0;

            while (step != max) {
                if (isPosValid(row - 2, col + 1, n) && grid[row - 2][col + 1] == step + 1) {
                    row = row - 2;
                    col = col + 1;
                    step++;
                } else if (isPosValid(row - 1, col + 2, n) && grid[row - 1][col + 2] == step + 1) {
                    row = row - 1;
                    col = col + 2;
                    step++;
                } else if (isPosValid(row + 1, col + 2, n) && grid[row + 1][col + 2] == step + 1) {
                    row = row + 1;
                    col = col + 2;
                    step++;
                } else if (isPosValid(row + 2, col + 1, n) && grid[row + 2][col + 1] == step + 1) {
                    row = row + 2;
                    col = col + 1;
                    step++;
                } else if (isPosValid(row + 2, col - 1, n) && grid[row + 2][col - 1] == step + 1) {
                    row = row + 2;
                    col = col - 1;
                    step++;
                } else if (isPosValid(row + 1, col - 2, n) && grid[row + 1][col - 2] == step + 1) {
                    row = row + 1;
                    col = col - 2;
                    step++;
                } else if (isPosValid(row - 1, col - 2, n) && grid[row - 1][col - 2] == step + 1) {
                    row = row - 1;
                    col = col - 2;
                    step++;
                } else if (isPosValid(row - 2, col - 1, n) && grid[row - 2][col - 1] == step + 1) {
                    row = row - 2;
                    col = col - 1;
                    step++;
                } else {
                    return false;
                }
            }

            return true;
        }

        private boolean isPosValid(int row, int col, int n) {
            return row >= 0 && col >= 0 && row < n && col < n;
        }
    }
}
