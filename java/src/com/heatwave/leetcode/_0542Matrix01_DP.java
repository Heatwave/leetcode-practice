package com.heatwave.leetcode;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * Example 2:
 * <p>
 * <p>
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 *  
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0542Matrix01_DP {
    static class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length;

            int[][] newMat = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    newMat[i][j] = 999999;
                    if (mat[i][j] == 0) {
                        newMat[i][j] = 0;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i - 1 >= 0) {
                        newMat[i][j] = Math.min(newMat[i][j], newMat[i - 1][j] + 1);
                    }
                    if (j - 1 >= 0) {
                        newMat[i][j] = Math.min(newMat[i][j], newMat[i][j - 1] + 1);
                    }
                }
            }

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i + 1 < m) {
                        newMat[i][j] = Math.min(newMat[i][j], newMat[i + 1][j] + 1);
                    }
                    if (j + 1 < n) {
                        newMat[i][j] = Math.min(newMat[i][j], newMat[i][j + 1] + 1);
                    }
                }
            }

            return newMat;
        }
    }
}
