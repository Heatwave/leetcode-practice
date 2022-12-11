package com.heatwave.contest.weekly._20221211_323;

public class _6257DeleteGreatestValueInEachRow {
    static class Solution {
        public int deleteGreatestValue(int[][] grid) {
            int ans = 0;
            int m = grid.length, n = grid[0].length;

            int count = n;

            while (count-- > 0) {
                int gridMax = 0;
                for (int i = 0; i < m; i++) {
                    int[] rowMax = new int[3];
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] > rowMax[0]) {
                            rowMax[0] = grid[i][j];
                            rowMax[1] = i;
                            rowMax[2] = j;
                        }
                    }
                    grid[rowMax[1]][rowMax[2]] = -1;
                    gridMax = Math.max(gridMax, rowMax[0]);
                    rowMax[0] = -1;
                }
                ans += gridMax;
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{10}};
//        int[][] grid = {{1, 2, 4}, {3, 3, 1}};
        int ans = solution.deleteGreatestValue(grid);
        System.out.println(ans);
    }
}
