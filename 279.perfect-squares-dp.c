/**
279. Perfect Squares
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */

// gcc 279.perfect-squares-dp.c

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <limits.h>

#define MIN(a, b) ((a) < (b) ? (a) : (b))

int numSquares(int n)
{
    int *dp = (int *)malloc(sizeof(int) * (n + 1));
    for (int i = 0; i < n + 1; ++i)
        dp[i] = INT_MAX;
    dp[0] = 0;

    int tmp = (int)sqrt((double)n);
    int maxSquareIndex = tmp + 1;

    int *squareNums = (int *)malloc(sizeof(int) * (maxSquareIndex + 1));
    for (int i = 1; i <= maxSquareIndex; ++i)
        squareNums[i] = i * i;

    for (int i = 1; i <= n; ++i)
    {
        for (int j = 1; j < maxSquareIndex; ++j)
        {
            if (i < squareNums[j])
                break;
            dp[i] = MIN(dp[i], dp[i - squareNums[j]] + 1);
        }
    }

    return dp[n];
}

int main()
{
    int res = numSquares(7168);
    printf("res: %d\n", res);
    return 0;
}
