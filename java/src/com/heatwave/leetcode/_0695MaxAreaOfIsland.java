package com.heatwave.leetcode;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 * <p>
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 *  
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0695MaxAreaOfIsland {
    static class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length, n = grid[0].length;

            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        max = Math.max(max, area(grid, new int[m][n], i, j));
                    }
                }
            }
            return max;
        }

        private int area(int[][] grid, int[][] checked, int m, int n) {
            if (m >= grid.length || n >= grid[0].length || m < 0 || n < 0 ||
                    checked[m][n] == 1 || grid[m][n] == 0) {
                return 0;
            }
            checked[m][n] = 1;
            return 1 + area(grid, checked, m, n + 1) +
                    area(grid, checked, m + 1, n) +
                    area(grid, checked, m, n - 1) +
                    area(grid, checked, m - 1, n);
        }
    }
}
