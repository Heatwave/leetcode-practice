package com.heatwave.leetcode.contest.biweekly._20221126_92;

/**
 * 6277. Difference Between Ones and Zeros in Row and Column
 * You are given a 0-indexed m x n binary matrix grid.
 * <p>
 * A 0-indexed m x n difference matrix diff is created with the following procedure:
 * <p>
 * Let the number of ones in the ith row be onesRowi.
 * Let the number of ones in the jth column be onesColj.
 * Let the number of zeros in the ith row be zerosRowi.
 * Let the number of zeros in the jth column be zerosColj.
 * diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
 * Return the difference matrix diff.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[0,1,1],[1,0,1],[0,0,1]]
 * Output: [[0,0,4],[0,0,4],[-2,-2,2]]
 * Explanation:
 * - diff[0][0] = onesRow0 + onesCol0 - zerosRow0 - zerosCol0 = 2 + 1 - 1 - 2 = 0
 * - diff[0][1] = onesRow0 + onesCol1 - zerosRow0 - zerosCol1 = 2 + 1 - 1 - 2 = 0
 * - diff[0][2] = onesRow0 + onesCol2 - zerosRow0 - zerosCol2 = 2 + 3 - 1 - 0 = 4
 * - diff[1][0] = onesRow1 + onesCol0 - zerosRow1 - zerosCol0 = 2 + 1 - 1 - 2 = 0
 * - diff[1][1] = onesRow1 + onesCol1 - zerosRow1 - zerosCol1 = 2 + 1 - 1 - 2 = 0
 * - diff[1][2] = onesRow1 + onesCol2 - zerosRow1 - zerosCol2 = 2 + 3 - 1 - 0 = 4
 * - diff[2][0] = onesRow2 + onesCol0 - zerosRow2 - zerosCol0 = 1 + 1 - 2 - 2 = -2
 * - diff[2][1] = onesRow2 + onesCol1 - zerosRow2 - zerosCol1 = 1 + 1 - 2 - 2 = -2
 * - diff[2][2] = onesRow2 + onesCol2 - zerosRow2 - zerosCol2 = 1 + 3 - 2 - 0 = 2
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [[1,1,1],[1,1,1]]
 * Output: [[5,5,5],[5,5,5]]
 * Explanation:
 * - diff[0][0] = onesRow0 + onesCol0 - zerosRow0 - zerosCol0 = 3 + 2 - 0 - 0 = 5
 * - diff[0][1] = onesRow0 + onesCol1 - zerosRow0 - zerosCol1 = 3 + 2 - 0 - 0 = 5
 * - diff[0][2] = onesRow0 + onesCol2 - zerosRow0 - zerosCol2 = 3 + 2 - 0 - 0 = 5
 * - diff[1][0] = onesRow1 + onesCol0 - zerosRow1 - zerosCol0 = 3 + 2 - 0 - 0 = 5
 * - diff[1][1] = onesRow1 + onesCol1 - zerosRow1 - zerosCol1 = 3 + 2 - 0 - 0 = 5
 * - diff[1][2] = onesRow1 + onesCol2 - zerosRow1 - zerosCol2 = 3 + 2 - 0 - 0 = 5
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * grid[i][j] is either 0 or 1.
 */
public class _6277DifferenceBetweenOnesAndZerosInRowAndColumn {
    static class Solution {
        public int[][] onesMinusZeros(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int[][] diff = new int[m][n];

            int[] oneRowDp = new int[m];
            int[] oneColDp = new int[n];
            int[] zeroRowDp = new int[m];
            int[] zeroColDp = new int[n];

            for (int i = 0; i < m; i++) {
                oneRowDp[i] = zeroRowDp[i] = -1;
            }
            for (int i = 0; i < n; i++) {
                oneColDp[i] = zeroColDp[i] = -1;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int oneRow = 0, zeroRow = 0;
                    if (oneRowDp[i] != -1 && zeroRowDp[i] != -1) {
                        oneRow = oneRowDp[i];
                        zeroRow = zeroRowDp[i];
                    } else {
                        for (int k = 0; k < n; k++) {
                            if (grid[i][k] == 1) {
                                oneRow++;
                            } else {
                                zeroRow++;
                            }
                        }
                        oneRowDp[i] = oneRow;
                        zeroRowDp[i] = zeroRow;
                    }

                    int oneCol = 0, zeroCol = 0;
                    if (oneColDp[j] != -1 && zeroColDp[j] != -1) {
                        oneCol = oneColDp[j];
                        zeroCol = zeroColDp[j];
                    } else {
                        for (int k = 0; k < m; k++) {
                            if (grid[k][j] == 1) {
                                oneCol++;
                            } else {
                                zeroCol++;
                            }
                        }
                        oneColDp[j] = oneCol;
                        zeroColDp[j] = zeroCol;
                    }
                    diff[i][j] = oneRow + oneCol - zeroRow - zeroCol;
                }
            }

            return diff;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.println(a[i]);
        }
    }
}
