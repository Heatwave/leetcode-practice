package com.heatwave.template.algorithms;

import java.util.Arrays;

public class PrefixSum {
    private static void prefixSum() {
        int[] a = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] s = new int[11];
        for (int i = 1; i <= 10; i++) {
            s[i] = s[i - 1] + a[i];
        }
        System.out.println(Arrays.toString(s));

        System.out.println(s[10]);

        int ans = s[10] - s[7];
        System.out.println(ans);
    }

    private static void prefixSumTwoDimension() {
        int[][] mat = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        int m = mat.length;
        int n = mat[0].length;
        int[][] s = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    s[i][j] = mat[i][j];
                } else if (i == 0) {
                    s[i][j] = s[i][j - 1] + mat[i][j];
                } else if (j == 0) {
                    s[i][j] = s[i - 1][j] + mat[i][j];
                } else {
                    s[i][j] = mat[i][j] + s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(s[i]));
        }

        // [1,1] ~ [2,2]
        int ans = s[2][2] - s[2][0] - s[0][2] + s[0][0];
        System.out.println(ans);
    }
}
